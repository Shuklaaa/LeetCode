//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        long[] res = new long[2];
        res[0] = fStart(v, x);
        res[1] = fEnd(v, x);
        pair p = new pair(res[0], res[1]);
        return p;
    }
    
    public long fStart(long[] v, long x){
        int s = 0, e = v.length - 1;
        int idx = -1;
        while(s <= e){
            int m = s + (e - s) / 2;
            if(v[m] == x){
                idx = m;
            }
            
            if(v[m] >= x){
                e = m - 1;
            }
            else{
                s = m + 1;
            }
        }
        return idx;
    }
    
    public long fEnd(long[] v, long x){
        int s = 0, e = v.length - 1;
        int idx = -1;
        while(s <= e){
            int m = s + (e - s) / 2;
            if(v[m] == x){
                idx = m;
            }
            
            if(v[m] <= x){
                s = m + 1;
            }
            else{
                e = m - 1;
            }
        }
        return idx;
    }
}