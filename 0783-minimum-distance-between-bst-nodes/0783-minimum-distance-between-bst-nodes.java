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
    int prev = -100000000;
    int diff = Integer.MAX_VALUE;
    public void dfs(TreeNode root){
        if(root == null) return;
        
        if(root.left != null) dfs(root.left);
        diff = Math.min(diff, root.val - prev);
        prev = root.val;
        if(root.right != null) dfs(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return diff;
    }
}