package com.github.sorting.src.main.java.com.github.shehanperera.algo;

import com.codahale.metrics.Timer;

public class InsertionSort {

    private Timer.Context context;

    public int[] interstionsort(int list[]) {

        context = MetricsServer.getInstance().getInsertionSortTime().time();
        int size = list.length;
        for (int i = 1; i < size; i++) {
            int key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
        context.stop();
        return list;

    }
}