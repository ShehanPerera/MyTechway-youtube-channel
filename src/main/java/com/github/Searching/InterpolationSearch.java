package com.github.Searching;

public class InterpolationSearch {
    public String InterpolationSearch(int list[], int element) {

        String result;

        int n = list.length;
        boolean found2 = InterpolationSearching(list, element);
        if (found2) {
            result = "Found";
        } else {
            result = "Not Found";
        }
        return result;

    }

    public boolean InterpolationSearching(int list[], int x) {
        boolean found = false;
        int lo = 0, hi = (list.length - 1);

        while (lo <= hi && x >= list[lo] && x <= list[hi]) {

            int pos = lo + (((hi - lo) /
                    (list[hi] - list[lo])) * (x - list[lo]));

            if (list[pos] == x) {
                found = true;

            }

            if (list[pos] < x) {
                lo = pos + 1;
            } else {
                hi = pos - 1;
            }
            return found;
        }
        return found;
    }
}
