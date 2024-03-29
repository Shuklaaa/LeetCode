//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        int[] level = new int[V];
        Arrays.fill(level, -1);
        
        // Perform a BFS traversal starting from node 0.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        level[0] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : adj.get(currentNode)) {
                if (level[neighbor] == -1) {
                    level[neighbor] = level[currentNode] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        // Check if node X exists in the graph and return its level.
        if (X >= 0 && X < V) {
            return level[X];
        }
        
        // If node X doesn't exist in the graph, return -1.
        return -1;
    }
}