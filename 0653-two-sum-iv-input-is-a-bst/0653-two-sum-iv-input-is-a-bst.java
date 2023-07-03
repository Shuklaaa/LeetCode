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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        
        int start = 0, end = res.size() - 1;
        
        while(start < end){
            int val1 = res.get(start);
            int val2 = res.get(end);
            
            if(val1 + val2 == k){
                return true;
            }
            
            else if(val1 + val2 < k){
                start++;
            }
            else{
                end--;
            }
        }
        return false;
    }
    
    public void dfs(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
