//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int shortestDistance(int N, int M, int[][] A, int X, int Y) {
        // Check if starting cell (0,0) has value 0, return -1 (impossible to reach)
        if (A[0][0] == 0)
            return -1;
        
        // Create a queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();
        
        // Define directions (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // Initialize visited array to keep track of visited cells
        boolean[][] visited = new boolean[N][M];
        
        // Start from the cell (0, 0) and mark it as visited
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int shortestDist = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                
                // Check if the current cell is the target cell (X, Y)
                if (x == X && y == Y)
                    return shortestDist;
                
                // Explore the neighboring cells (up, down, left, right)
                for (int k = 0; k < 4; k++) {
                    int newX = x + dx[k];
                    int newY = y + dy[k];
                    
                    // Check if the new coordinates are within the grid boundaries,
                    // contain value 1, and not visited yet
                    if (newX >= 0 && newX < N && newY >= 0 && newY < M && A[newX][newY] == 1 && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            shortestDist++; // Increment distance for each level of BFS traversal
        }
        
        // If the target cell (X, Y) is not found, return -1 (impossible to reach)
        return -1;
    }
}
