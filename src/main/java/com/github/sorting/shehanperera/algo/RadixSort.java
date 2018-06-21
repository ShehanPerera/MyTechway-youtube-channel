/*
 * Copyright 2018 Shehan Perera
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.sorting.shehanperera.algo;

import com.codahale.metrics.Timer;

import java.util.Arrays;

public class RadixSort {

    private Timer.Context context;

    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    /* A function to do counting sort of arr[] according to
     the digit represented by exp.
     Store count of occurrences in count[] and
     change count[i] so that count[i] now contains
     actual position of this digit in output[]
     finally build the output array */
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /* The main function to that sorts arr[] of size n using
     Radix Sort
     Find the maximum number to know number of digits then
     do counting sort for every digit. Note that instead
     of passing digit number, exp is passed. exp is 10^i
     where i is current digit number */
    public int[] radixsort(int list[]) {
        context = MetricsServer.getInstance().getRadixSortTime().time();
        int n = list.length;
        int m = getMax(list, n);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(list, n, exp);
        }
        context.stop();
        return list;
    }

}