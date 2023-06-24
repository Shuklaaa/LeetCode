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
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        
        return ans;
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lh = Math.max(0 , helper(root.left));
        int rh = Math.max(0 , helper(root.right));
        
        ans = Math.max(ans, root.val + lh + rh);
        
        return root.val + Math.max(lh , rh);
    }
}