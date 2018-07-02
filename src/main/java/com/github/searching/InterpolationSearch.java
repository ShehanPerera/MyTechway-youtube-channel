package com.github.searching;

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

        boolean found = InterpolationSearching(list, element);
        if (found) {
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
    private boolean InterpolationSearching(int list[], int x) {
        boolean found = false;
        int low = 0, high = (list.length - 1);

        while (low <= high && x >= list[low] && x <= list[high]) {

            int pos = low + (((high - low) /
                    (list[high] - list[low])) * (x - list[low]));

            if (list[pos] == x) {
                found = true;

            }

            if (list[pos] < x) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
            return found;
        }
        return found;
    }
}
