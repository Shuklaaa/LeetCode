//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int l;
            l = sc.nextInt();

            int r;
            r = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.findXOR(l, r);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int findXOR(int l, int r) {
        return (findxOR(l - 1) ^ findxOR(r));
    }
    
    static int findxOR(int n)
    {
        int mod = n % 4;
 
        // If n is a multiple of 4
        if (mod == 0)
            return n;
 
        // If n % 4 gives remainder 1
        else if (mod == 1)
            return 1;
 
        // If n % 4 gives remainder 2
        else if (mod == 2)
            return n + 1;
 
        // If n % 4 gives remainder 3
        else if (mod == 3)
            return 0;
        return 0;
    }
}