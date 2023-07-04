//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        if (k <= 1) {
            // If k is less than or equal to 1, no subarray can have a product less than k.
            return 0;
        }

        int count = 0;
        long product = 1;
        int left = 0;

        for (int right = 0; right < n; right++) {
            product *= a[right];

            // Shrink the window by removing elements from the left side
            while (product >= k) {
                product /= a[left];
                left++;
            }

            // All the subarrays ending at 'right' satisfy the condition
            // (product of elements < k). So, add the count of subarrays.
            count += (right - left + 1);
        }

        return count;
    }
}