//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;
import java.math.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    public static ArrayList<Integer> findCommon(Node root1, Node root2)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node current1 = root1;
        Node current2 = root2;

        while (current1 != null || current2 != null || !stack1.isEmpty() || !stack2.isEmpty())
        {
            // Reach the leftmost node in both BSTs.
            while (current1 != null)
            {
                stack1.push(current1);
                current1 = current1.left;
            }
            while (current2 != null)
            {
                stack2.push(current2);
                current2 = current2.left;
            }

            // If there are nodes in the stacks, pop and compare them.
            if (!stack1.isEmpty() && !stack2.isEmpty())
            {
                current1 = stack1.peek();
                current2 = stack2.peek();

                if (current1.data == current2.data)
                {
                    result.add(current1.data);
                    stack1.pop();
                    stack2.pop();
                    current1 = current1.right;
                    current2 = current2.right;
                }
                else if (current1.data < current2.data)
                {
                    stack1.pop();
                    current1 = current1.right;
                    current2 = null;
                }
                else
                {
                    stack2.pop();
                    current2 = current2.right;
                    current1 = null;
                }
            }
            // If any stack is empty, continue traversing the other tree.
            else if (stack1.isEmpty())
            {
                current2 = stack2.pop();
                current2 = current2.right;
            }
            else
            {
                current1 = stack1.pop();
                current1 = current1.right;
            }
        }

        return result;
    }
}


//{ Driver Code Starts.
class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution g = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.findCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}
// } Driver Code Ends