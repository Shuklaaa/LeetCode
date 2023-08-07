//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java
class Solution
{
    // Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][])
    {
        int N = grid.length;
        int[] row = new int[N];
        int[] col = new int[N];
        int[][] box = new int[3][3];

        // Initialize the row, column, and box arrays
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    int num = grid[i][j];
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if ((row[i] & (1 << num)) != 0 || (col[j] & (1 << num)) != 0 || (box[boxIndex / 3][boxIndex % 3] & (1 << num)) != 0) {
                        return false; // Invalid configuration
                    }
                    row[i] |= (1 << num);
                    col[j] |= (1 << num);
                    box[boxIndex / 3][boxIndex % 3] |= (1 << num);
                }
            }
        }

        // Start backtracking to find a solution
        return solveSudokuHelper(grid, row, col, box, 0, 0);
    }

    // Helper function for backtracking
    static boolean solveSudokuHelper(int grid[][], int[] row, int[] col, int[][] box, int i, int j) {
        int N = grid.length;
        if (i == N) {
            return true; // Entire grid is filled, solution found
        }

        if (j == N) {
            return solveSudokuHelper(grid, row, col, box, i + 1, 0); // Move to the next row
        }

        if (grid[i][j] != 0) {
            return solveSudokuHelper(grid, row, col, box, i, j + 1); // Skip filled cells
        }

        int boxIndex = (i / 3) * 3 + j / 3;
        for (int num = 1; num <= 9; num++) {
            if ((row[i] & (1 << num)) == 0 && (col[j] & (1 << num)) == 0 && (box[boxIndex / 3][boxIndex % 3] & (1 << num)) == 0) {
                grid[i][j] = num;
                row[i] |= (1 << num);
                col[j] |= (1 << num);
                box[boxIndex / 3][boxIndex % 3] |= (1 << num);

                if (solveSudokuHelper(grid, row, col, box, i, j + 1)) {
                    return true; // Found a solution
                }

                // If the current choice doesn't lead to a solution, backtrack
                grid[i][j] = 0;
                row[i] &= ~(1 << num);
                col[j] &= ~(1 << num);
                box[boxIndex / 3][boxIndex % 3] &= ~(1 << num);
            }
        }

        return false; // No solution found for the current configuration
    }

    // Function to print grids of the Sudoku.
    static void printGrid(int grid[][])
    {
        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
