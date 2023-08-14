//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Step 1: Calculate the XOR of all numbers in the array
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        
        // Step 2: Find the rightmost set bit in the XOR result
        int rightmostSetBit = 1;
        while ((rightmostSetBit & xorResult) == 0) {
            rightmostSetBit <<= 1;
        }
        
        // Step 3: Divide the numbers into two groups based on the rightmost set bit
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        // Return the two distinct numbers in ascending order
        return new int[]{Math.min(num1, num2), Math.max(num1, num2)};
    }
}
