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
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (B[b[1]] + A[b[0]]) - (B[a[1]] + A[a[0]]));
        Set<String> s = new HashSet<>();
        pq.add(new int[]{N - 1, N - 1});
        s.add((N - 1) + "," + (N - 1));

        while (K > 0) {
            int[] indices = pq.poll();
            int i = indices[0];
            int j = indices[1];
            int sum = A[i] + B[j];
            ans.add(sum);

            if (i > 0 && !s.contains((i - 1) + "," + j)) {
                pq.add(new int[]{i - 1, j});
                s.add((i - 1) + "," + j);
            }

            if (j > 0 && !s.contains(i + "," + (j - 1))) {
                pq.add(new int[]{i, j - 1});
                s.add(i + "," + (j - 1));
            }

            K--;
        }

        return ans;
    }
}
