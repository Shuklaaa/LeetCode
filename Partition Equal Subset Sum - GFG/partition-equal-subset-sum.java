//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        // If the sum is odd, it cannot be partitioned into two equal sum subsets.
        if (sum % 2 != 0) {
            return 0;
        }

        int targetSum = sum / 2;

        // Create a DP table to store whether a subset with a given sum is possible.
        boolean dp[][] = new boolean[N + 1][targetSum + 1];

        // Initialize the first row, representing an empty subset.
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= targetSum; j++) {
                // If the current element is greater than the target sum, we can't include it.
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, we have two options: include or exclude the current element.
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // If dp[N][targetSum] is true, it means it's possible to partition the array into two equal sum subsets.
        if (dp[N][targetSum]) {
            return 1;
        } else {
            return 0;
        }
    }
}
