package com.github;

import com.github.Metrics.MetricsServer;
import com.github.sorting.*;

import java.util.Arrays;

/**
 * This is simple example to use lib
 */
public class ExampleRun {
    public static void main(String[] args) {
        MetricsServer.getInstance().startReport();

        System.out.println("Hello algo!!");

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
        ExampleRun exampleRun = new ExampleRun();
        exampleRun.waitMethod();

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
