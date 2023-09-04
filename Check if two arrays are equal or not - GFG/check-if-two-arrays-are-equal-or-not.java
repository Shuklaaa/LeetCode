//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    // Function to check if two arrays are equal or not.
    public static boolean check(long A[], long B[], int N) {
        // Check if the lengths of the arrays are not equal, return false
        if (A.length != B.length) {
            return false;
        }

        // Create HashMaps to store element frequencies
        Map<Long, Integer> freqA = new HashMap<>();
        Map<Long, Integer> freqB = new HashMap<>();

        // Count the frequencies of elements in array A
        for (int i = 0; i < N; i++) {
            freqA.put(A[i], freqA.getOrDefault(A[i], 0) + 1);
            freqB.put(B[i], freqB.getOrDefault(B[i], 0) + 1);
        }

        // Compare the frequencies of elements in both arrays
        return freqA.equals(freqB);
    }
}
