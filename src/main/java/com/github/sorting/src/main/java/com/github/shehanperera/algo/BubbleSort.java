package com.github.sorting.src.main.java.com.github.shehanperera.algo;


import com.codahale.metrics.Timer;

public class BubbleSort {

    private Timer.Context context;

    public int[] bubbleSort(int list[]) {

        context = MetricsServer.getInstance().getBubbleSortTime().time();
        int n = list.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
        context.stop();
        return list;
    }
}