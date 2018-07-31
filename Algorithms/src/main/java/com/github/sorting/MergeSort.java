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
package com.github.sorting;

/** This is the class for Merge sort **/
public class MergeSort {

    /** Constructor for mergesort
     *
     * @param list is unsorted number list from user
     * @return sorted list
     */
    public int[] mergesort(int list[]) {

        sort(list, 0, list.length - 1);
        return list;
    }

    /**
     * This for merge arrays
     *  Merges two subarrays of list[].
     *  First subarray is list[start..middle]
     *  Second subarray is list[middle+1..last]
     * @param list
     * @param start  starting point of array
     * @param middle middle point of array
     * @param last last point of array
     */
    void merge(int list[], int start, int middle, int last) {

        int n1 = middle - start + 1;
        int n2 = last - middle;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = list[start + i];
        for (int j = 0; j < n2; ++j)
            R[j] = list[middle + 1 + j];

        int i = 0, j = 0;

        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
            } else {
                list[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            list[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            list[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Sorting list[start...last]
     * @param list
     * @param start starting point of array
     * @param last final point of array
     */
    void sort(int list[], int start, int last) {
        if (start < last) {
            int middle = (start + last) / 2;
            sort(list, start, middle);
            sort(list, middle + 1, last);
            merge(list, start, middle, last);
        }
    }
}