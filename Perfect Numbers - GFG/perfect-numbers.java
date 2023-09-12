//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long n) {
        // Base case: Perfect numbers are always even
        if (n % 2 != 0) {
            return 0;
        }
        
        long sum = 1; // Start with 1 as a factor (every number has 1 as a factor)
        long sqrtN = (long) Math.sqrt(n);
        
        for (long i = 2; i <= sqrtN; i++) {
            if (n % i == 0) {
                // i is a factor of n
                sum += i;
                
                // If i is not equal to n / i, add n / i as well
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        
        // Check if the sum of factors is equal to n
        if (sum == n) {
            return 1;
        }
        
        return 0;
    }
}
