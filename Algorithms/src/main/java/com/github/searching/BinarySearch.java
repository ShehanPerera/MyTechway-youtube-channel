package com.github.searching;

public class BinarySearch {
    private boolean found = false;

    /**
     * A recursive binary search function. It returns found massage
     * of x in given array arr[l..r] is present,
     * otherwise returns not found massage
     *
     * @param list    data set for search
     * @param element is search element
     * @return found or not found massage
     */
    public String BinarySearch(int list[], int element) {

        String result;
        int n = list.length;
        boolean found = BinarySearching(list, 0, n - 1, element);
        if (found) {
            result = "Found";
        } else {
            result = "Not Found";
        }
        return result;

    }

    /**
     * Returns index of x if it is present in arr[l..r] true , else return false
     *
     * @param list    data set for search
     * @param l       location for first element in array
     * @param n       length for array
     * @param element is search element
     * @return true or false massage
     */
    private boolean BinarySearching(int list[], int l, int n, int element) {

        if (n >= l) {
            int mid = l + (n - l) / 2;

            if (list[mid] == element) {
                found = true;
            } else if (list[mid] > element) {
                return BinarySearching(list, l, mid - 1, element);
            } else if (list[mid] < element) {
                return BinarySearching(list, mid + 1, n, element);
            }
            return found;
        }
        return found;
    }

}