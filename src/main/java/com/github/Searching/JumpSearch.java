package com.github.Searching;

public class JumpSearch {

    public String jumpSearch(int list[], int element) {

        String result;

        int n = list.length;
        boolean found2 = jumpSearching(list, element);
        if (found2) {
            result = "Found";
        } else {
            result = "Not Found";
        }
        return result;

    }

    public boolean jumpSearching(int list[], int element) {
        boolean found = false;
        int n = list.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;
        while (list[Math.min(step, n) - 1] < element) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return found;
            }
        }

        while (list[prev] < element) {
            prev++;
            if (prev == Math.min(step, n)) {
                return found;
            }
        }

        if (list[prev] == element) {
            found = true;
        }
        return found;
    }

}
