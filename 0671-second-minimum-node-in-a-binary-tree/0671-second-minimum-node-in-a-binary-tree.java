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
    long min = Long.MAX_VALUE;
    public void dfs(TreeNode root, int value){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        if(root.left.val != root.right.val){
            min = Math.min(min, Math.max(root.left.val, root.right.val));
        }
        dfs(root.left, value);
        dfs(root.right, value);
        
    }
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return (min == Long.MAX_VALUE) ? -1 : (int)min;
    }
}