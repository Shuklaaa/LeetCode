//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


class Solution {
    // Create a global variable to keep track of the sorted values
    List<Integer> sortedList = new ArrayList<>();
    
    // Function to perform an in-order traversal and store values in sortedList
    void inOrderTraversal(Node root) {
        if (root == null) return;
        
        inOrderTraversal(root.left);
        sortedList.add(root.data);
        inOrderTraversal(root.right);
    }
    
    // Function to convert the binary tree to a binary search tree
    void convertToBST(Node root, int[] index) {
        if (root == null) return;
        
        convertToBST(root.left, index);
        root.data = sortedList.get(index[0]);
        index[0]++;
        convertToBST(root.right, index);
    }
    
    // Function to convert a binary tree to a binary search tree
    Node binaryTreeToBST(Node root) {
        // Step 1: Perform in-order traversal and store values in sortedList
        inOrderTraversal(root);
        
        // Step 2: Sort the values
        Collections.sort(sortedList);
        
        // Step 3: Convert the binary tree to a binary search tree
        int[] index = {0};
        convertToBST(root, index);
        
        return root;
    }
}
