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

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MetricsServer.getInstance().startReport();

        System.out.println("Hello World!");


        int elementsList[] = new int[100];
        for (int i = 0; i < 100; i++) {
            elementsList[i] = 100 - i;
        }
        BubbleSort bubbleSort = new BubbleSort();
        elementsList = bubbleSort.bubbleSort(elementsList);

        HeapSort heapSort = new HeapSort();
        elementsList = heapSort.heapsort(elementsList);

        MergeSort mergeSort = new MergeSort();
        elementsList = mergeSort.mergesort(elementsList);

        InsertionSort insertionSort = new InsertionSort();
        elementsList = insertionSort.interstionsort(elementsList);

        QuickSort quickSort = new QuickSort();
        elementsList = quickSort.quicksort(elementsList);

        RadixSort radixSort = new RadixSort();
        elementsList = radixSort.radixsort(elementsList);

        SelectionSort selectionSort = new SelectionSort();
        elementsList = selectionSort.selectionsort(elementsList);

        System.out.println(Arrays.toString(elementsList));
        App app = new App();
        app.waitMethod();

    }

    private synchronized void waitMethod() {

        while (true) {
            try {
                this.wait(1);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}
