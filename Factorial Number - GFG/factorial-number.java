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
        int factorial = 1;
        int i = 1;
        
        while (factorial < N) {
            i++;
            factorial *= i;
        }
        
        if (factorial == N) {
            return 1;
        }
        
        return 0;
    }
}