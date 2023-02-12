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
    
    public int dfs(TreeNode root, long target){
        if(root == null) return 0;
        
        target -= root.val;
        int path = (target == 0) ? 1 : 0;
        
        path += dfs(root.left, target);
        path += dfs(root.right, target);
        
        return path;
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return dfs(root, targetSum) + 
               pathSum(root.left, targetSum) +
               pathSum(root.right, targetSum);
    }
}