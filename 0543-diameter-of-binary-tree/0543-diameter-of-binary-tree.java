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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        
        return ans;
    }
    
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lh = depth(root.left);
        int rh = depth(root.right);
        
        ans = Math.max(ans, lh + rh);
        
        return 1 + Math.max(lh, rh); //height
    }
}