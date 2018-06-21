package com.github.sorting.src.main.java.com.github.shehanperera.algo;

import com.codahale.metrics.Timer;

public class HeapSort {

    private Timer.Context context;

    /* Build heap (rearrange array)
    One by one extract an element from heap */
    public int[] heapsort(int list[]) {


        context = MetricsServer.getInstance().getHeapSortTime().time();
        int n = list.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            heapify(list, i, 0);
        }
        context.stop();
        return list;
    }

    /* To heapify a subtree rooted with node i which is
     an index in arr[]. n is size of heap */
    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}