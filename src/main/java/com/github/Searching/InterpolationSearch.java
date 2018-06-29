package com.github.Searching;

public class InterpolationSearch {
    /**
     * A recursive InterpolationSearch function. It returns found massage
     of x in given array arr[l..r] is present,
     otherwise returns not found massage
     * @param list data set for search
     * @param element is search element
     * @return found or not found massage
     */
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

    /**
     * If x is present in arr[0..n-1], then returns
      true of it, else returns false.
     The idea of formula is to return higher value of pos
     when element to be searched is closer to list[hi]. And
     maller value when closer to list[lo]
     * @param list  data set for search
     * @param x is search element
     * @return true or false
     */
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
