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

import com.codahale.metrics.Timer;
import com.github.metrics.MetricsServer;

/**
 * This class used for sort an array using Selection sort method
 */
public class SelectionSort {

    private Timer.Context context;

    public int[] selectionsort(int list[]) {

        context = MetricsServer.getInstance().getSelectionSortTime().time();
        int size = list.length;
        for (int i = 0; i < size - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < size; j++)
                if (list[j] < list[min_idx])
                    min_idx = j;

            int temp = list[min_idx];
            list[min_idx] = list[i];
            list[i] = temp;
        }
        context.stop();
        return list;
    }

}
