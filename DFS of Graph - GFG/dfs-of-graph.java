//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create a boolean array to track visited nodes.
        boolean[] visited = new boolean[V];
        
        // Create a list to store the DFS traversal result.
        ArrayList<Integer> dfsTraversal = new ArrayList<>();
        
        // Start the DFS traversal from each unvisited node in the graph.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(i, adj, visited, dfsTraversal);
            }
        }
        
        return dfsTraversal;
    }
    
    // Helper method for DFS traversal.
    private void dfsUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsTraversal) {
        // Mark the current node as visited.
        visited[v] = true;
        
        // Add the current node to the DFS traversal result.
        dfsTraversal.add(v);
        
        // Recur for all the adjacent nodes that are not visited yet.
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited, dfsTraversal);
            }
        }
    }
}
