package com.github.searching;

import com.codahale.metrics.Timer;
import com.github.metrics.MetricsServer;

public class JumpSearch {
    private Timer.Context context;

    /**
     * A recursive JumpSearch function. It returns found massage
     * of element in given array arr[l..r] is present,
     * otherwise returns not found massage
     *
     * @param list    data set for search
     * @param element is search element
     * @return found or not found massage
     */
    public String JumpSearch(int list[], int element) {

        context = MetricsServer.getInstance().getJumpSearchTime().time();
        String result;
        boolean found = jumpSearching(list, element);
        if (found) {
            result = "Found";
        } else {
            result = "Not Found";
        }
        context.stop();
        return result;

    }

    /**
     * If x is present in arr[0..n-1], then returns
     * true of it, else returns false.
     *
     * @param list    data set for search
     * @param element is search element
     * @return true or false
     */
    private boolean jumpSearching(int list[], int element) {
        boolean found = false;
        int n = list.length;
        /**
         * Finding block size to be jumped
         */
        int step = (int) Math.floor(Math.sqrt(n));
        /**
         * Finding the block where element is
         present (if it is present)
         */
        int prev = 0;
        while (list[Math.min(step, n) - 1] < element) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return found;
            }
        }
        /**
         *Doing a linear search for x in block
         beginning with prev.
         */
        while (list[prev] < element) {
            prev++;
            /**
             *  If we reached next block or end of
             array, element is not present
             */
            if (prev == Math.min(step, n)) {
                return found;
            }
        }
        /**
         * If element is found
         */
        if (list[prev] == element) {
            found = true;
        }
        return found;
    }

}
