//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int[] arr, int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];

        int include = arr[0]; // Maximum amount including the current house.
        int exclude = 0;     // Maximum amount excluding the current house.

        for (int i = 1; i < n; i++)
        {
            // Calculate the new values of include and exclude.
            int newInclude = exclude + arr[i];
            int newExclude = Math.max(include, exclude);

            // Update include and exclude for the next house.
            include = newInclude;
            exclude = newExclude;
        }

        // The maximum amount will be the maximum of include and exclude.
        return Math.max(include, exclude);
    }
}
