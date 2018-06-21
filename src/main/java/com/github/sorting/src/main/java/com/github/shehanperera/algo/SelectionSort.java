package com.github.sorting.src.main.java.com.github.shehanperera.algo;

import com.codahale.metrics.Timer;

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
