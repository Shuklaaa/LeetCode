//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    // Function to return list containing first n Fibonacci numbers.
    public static long[] printFibb(int n)
    {
        long[] fibArray = new long[n];
        if (n >= 1) {
            fibArray[0] = 1;
        }
        if (n >= 2) {
            fibArray[1] = 1;
        }
        
        for (int i = 2; i < n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        
        return fibArray;
    }
}
