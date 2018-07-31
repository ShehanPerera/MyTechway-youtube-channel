package com.github;

import com.github.searching.BinarySearch;
import com.github.searching.InterpolationSearch;
import com.github.searching.JumpSearch;
import com.github.searching.LinearSearch;
import com.github.sorting.*;

import java.util.Arrays;

/**
 * This is simple example to use lib
 */
public class ExampleRun {
    public static void main(String[] args) {
        
        System.out.println("Hello algo!!");

        int elementsList[] = new int[100];
        for (int i = 0; i < 100; i++) {
            elementsList[i] = 100 - i;
        }
        /** Running Sorting algorithms */
        BubbleSort bubbleSort = new BubbleSort();
        elementsList = bubbleSort.bubbleSort(elementsList);

        HeapSort heapSort = new HeapSort();
        elementsList = heapSort.heapsort(elementsList);

        MergeSort mergeSort = new MergeSort();
        elementsList = mergeSort.mergesort(elementsList);

        InsertionSort insertionSort = new InsertionSort();
        elementsList = insertionSort.interstionsort(elementsList);

        QuickSort quickSort = new QuickSort();
        elementsList = quickSort.quicksort(elementsList);

        RadixSort radixSort = new RadixSort();
        elementsList = radixSort.radixsort(elementsList);

        SelectionSort selectionSort = new SelectionSort();
        elementsList = selectionSort.selectionsort(elementsList);

        /** End of Sorting algorithms */

       
        /**Searching algorithms */

        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Binary Search result for 70 : " + binarySearch.BinarySearch(elementsList, 70));

        InterpolationSearch interpolationSearch = new InterpolationSearch();
        System.out.println("Interpolation Search result for 80 : " + interpolationSearch.InterpolationSearch
                (elementsList, 80));

        JumpSearch jumpSearch = new JumpSearch();
        System.out.println("Jump Search result for -10 : " + jumpSearch.JumpSearch(elementsList, -10));

        LinearSearch linearSearch = new LinearSearch();
        System.out.println("Linear Search result for 50 : " + linearSearch.LinearSearch(elementsList, 50));

        /** End of Searching algorithms */

        System.out.println(Arrays.toString(elementsList));
       

    }

}
