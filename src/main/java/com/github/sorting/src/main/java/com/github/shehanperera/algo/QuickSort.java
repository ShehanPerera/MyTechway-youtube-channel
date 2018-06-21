package com.github.sorting.src.main.java.com.github.shehanperera.algo;

import com.codahale.metrics.Timer;

public class QuickSort {

    private Timer.Context context;

    public int[] quicksort(int list[]) {

        context = MetricsServer.getInstance().getQuickSortTime().time();
        int low = 0;
        int high = list.length;
        sort(list, low, high - 1);
        context.stop();
        return list;
    }


    int partition(int list[], int low, int high) {
        int pivot = list[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (list[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        int temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort()
         arr[] --> Array to be sorted,
         low  --> Starting index,
         high  --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {

            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}