//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformsNeeded = 1; // Minimum one platform needed
        int maxPlatforms = 1; // Maximum platforms needed at any time
        int i = 1; // Pointer for arrival times
        int j = 0; // Pointer for departure times

        // Merge intervals and calculate the number of platforms needed
        while (i < n && j < n) {
            // If the next event is an arrival, increment the platforms needed
            if (arr[i] <= dep[j]) {
                platformsNeeded++;
                i++;
            }
            // If the next event is a departure, decrement the platforms needed
            else {
                platformsNeeded--;
                j++;
            }

            // Update the maximum number of platforms needed
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }
    
}

