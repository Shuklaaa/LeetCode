//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isFactorial(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isFactorial(int N) {
        //code here
        if (N == 1) {
            return 1;
        }
        
        int low = 1;
        int high = N;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int factorial = 1;
            
            for (int i = 2; i <= mid; i++) {
                factorial *= i;
                
                if (factorial == N) {
                    return 1;
                } else if (factorial > N) {
                    high = mid - 1;
                    break;
                }
            }
            
            if (factorial < N) {
                low = mid + 1;
            }
        }
        
        return 0;
    }
}