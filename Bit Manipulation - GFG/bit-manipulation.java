//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int i = sc.nextInt();

            Solution obj = new Solution();
            obj.bitManipulation(n, i);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        // code here
        int get = getOp(num, i);
        int set = Set(num, i);
        int clr = clear(num, i);
        
        System.out.print(get + " " + set + " " + clr);
    }
    
    static int getOp(int num, int i){
        int BM = 1 << i - 1;
        if((BM & num) == 0){
            return 0;
        }
        return 1;
    }
    
    static int Set(int num, int i){
        int BM = 1 << i - 1;
        
        return (num | BM);
    }
    
    static int clear(int num, int i){
        int BM = 1 << i - 1;
        int newBitNOT = ~(BM);
        
        return (num & newBitNOT);
    }
}
