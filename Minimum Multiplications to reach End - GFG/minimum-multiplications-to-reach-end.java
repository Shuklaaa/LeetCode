//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int mod = 100000;
        int maxPossibleValue = 105 * 1000; // Maximum possible value after 105 multiplications
        
        boolean[] visited = new boolean[maxPossibleValue];
        
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        
        queue.offer(start);
        steps.offer(0);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentSteps = steps.poll();
            
            if (current == end) {
                return currentSteps;
            }
            
            for (int num : arr) {
                int nextValue = (current * num) % mod;
                
                if (!visited[nextValue]) {
                    visited[nextValue] = true;
                    queue.offer(nextValue);
                    steps.offer(currentSteps + 1);
                }
            }
        }
        
        return -1; 
    }
}
