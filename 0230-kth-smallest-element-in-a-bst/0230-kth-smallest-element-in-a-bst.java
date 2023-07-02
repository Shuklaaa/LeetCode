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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> li = new ArrayList<Integer>();
        
        dfs(li, root);
        
        return li.get(k-1);
    }
    
    public static void dfs(List<Integer> li, TreeNode root){
        if(root == null){
            return;
        }
        
        dfs(li, root.left);
        li.add(root.val);
        dfs(li, root.right);
    }
}