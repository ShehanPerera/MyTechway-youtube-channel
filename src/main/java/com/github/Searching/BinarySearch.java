package com.github.Searching;

public class BinarySearch {

    public boolean found = false;

    public String BinarySearch(int list[], int element) {

        String result;

        int n = list.length;
        boolean found2 = BinarySearching(list, 0, n - 1, element);
        if (found2) {
            result = "Found";
        } else {
            result = "Not Found";
        }
        return result;

    }

    public boolean BinarySearching(int list[], int l, int n, int element) {

        int x = element;
        if (n >= l) {
            int mid = l + (n - l) / 2;

            if (list[mid] == element) {
                found = true;
            } else if (list[mid] > element) {
                return BinarySearching(list, l, mid - 1, x);
            } else if (list[mid] < element) {
                return BinarySearching(list, mid + 1, n, x);
            }
            return found;
        }
        return found;
    }

}