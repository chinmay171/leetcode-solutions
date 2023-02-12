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
    
    public boolean dfs(TreeNode root, int target, int curr){
        if(root == null) return false;
        
        if(root.left == null && root.right == null){
            curr += root.val;
            if(target == curr) return true;
            return false;
        }
        
        curr = curr + root.val;
        return dfs(root.left, target, curr) ||
               dfs(root.right, target, curr);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, targetSum, 0);
    }
}