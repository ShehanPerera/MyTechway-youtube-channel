package com.github.Searching;

public class FibonacciSearch
{   
    // Utility function to find minimum 
    // of two elements
    public static int min(int x, int y) 
    { return (x <= y)? x : y; }
  public String FibonacciSearch(int list[],int element)
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
    public boolean FibonacciSearching(int list[], 
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