package com.github.searching;

import com.codahale.metrics.Timer;
import com.github.metrics.MetricsServer;

public class LinearSearch {
    private Timer.Context context;

    /**
     * Java code for linearly search x in arr[].  If x
     * is present  then return massage,  otherwise
     * return false massage
     *
     * @param list    data set for search
     * @param element is search element
     * @return found or not found massage
     */
    public String LinearSearch(int list[], int element) {

        context = MetricsServer.getInstance().getLinearSearchTime().time();
        int n = list.length;
        boolean found = false;
        String result;
        int i;
        for (i = 0; i < n; i++)
            if (list[i] == element) {
                found = true;
            }
        if (found) {
            result = "Found";
        } else {
            result = "Not Found";
        }
        context.stop();
        return result;

    }

}
