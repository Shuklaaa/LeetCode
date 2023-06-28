/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
			
      if(root.val==key && (root.right ==null && root.left==null))   { 
        root=null;
      return root;
      }
     
        if(root.val<key) // go to right 
        root.right=deleteNode(root.right,key);
		
            else if(root.val>key) // go to left 
            root.left=deleteNode(root.left,key);
			
             else {  // equal val  ----> 3 case l null r null or both are non null
						 if(root.right==null)
							 return root.left;
						 if(root.right==null)
							 return root.left;
						 else  {
							root.val= minHelper(root.right);
							 root.right=deleteNode(root.right,root.val);   
						 }
             }
                 
        return root;
    }
      
     public int minHelper(TreeNode root) // go to extreme left and udate root 
     {   int min=root.val;
         if(root==null)
             return min;
         while(root.left!=null){
             min=root.left.val;
             root=root.left;
             }
         return min;
     }
}