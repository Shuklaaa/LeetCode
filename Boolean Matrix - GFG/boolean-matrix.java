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
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to modify the matrix such that if a matrix cell matrix[i][j]
    // is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Arrays to keep track of whether a row or column needs to be modified.
        boolean[] modifyRow = new boolean[rows];
        boolean[] modifyCol = new boolean[cols];

        // Scan the matrix and mark the rows and columns to be modified.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    modifyRow[i] = true;
                    modifyCol[j] = true;
                }
            }
        }

        // Modify the matrix based on the marked rows and columns.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (modifyRow[i] || modifyCol[j]) {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
