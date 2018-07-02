package com.github.searching;

public class FibonacciSearch
{
    /**
     * Utlity function to find minimum
     of two elements
     */

    private static int min(int x, int y)
    { return (x <= y)? x : y; }

    /**
     *A recursive FibonacciSearch function. It returns found massage
     of x in given array arr[l..r] is present,
     otherwise returns not found massage
     * @param list data set for search
     * @param element is search element
     * @return found or not found massage
     */
  public String fibonacciSearch(int list[],int element)
    {
       
        String result;
		
        int n = list.length;
        boolean found2 =  FibonacciSearching(list,n,element);
        if (found2) {
            result = "Found";
        } else {
            result = "Not Found";
        }
        return result;

    }

    /**
     *Returns index of x if present is true, else returns false
     * @param list  data set for search
     * @param n length for array
     * @param x is search element
     * @return true or false
     */
    private boolean FibonacciSearching(int list[],
                                         int n, int x)
    {
		boolean found=false;
      
        int fibMMm2 = 0;
        int fibMMm1 = 1;
        int fibM = fibMMm2 + fibMMm1; 

        while (fibM < n)
        {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        int offset = -1;
 
        while (fibM > 1)
        {
            int i = min(offset+fibMMm2, n-1);
 
            if (list[i] < x)
            {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
				found = true;
            }
 
            else if (list[i] > x)
            {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }
 
          
            else return found;
        }
 
        return found;
    }

}