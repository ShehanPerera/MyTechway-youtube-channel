package com.github.Searching;

public class LinearSearch {

    public String LinearSearch(int list[], int element) {

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
        return result;

    }

}
