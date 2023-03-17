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
    public boolean dfs(TreeNode root, int limit, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            sum += root.val;
            if(sum >= limit) return true;
            else return false;
        }
        
        sum += root.val;
        boolean l = dfs(root.left, limit, sum);
        boolean r = dfs(root.right, limit, sum);
        
        if(l == false) root.left = null;
        if(r == false) root.right = null;
        
        return l || r;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        // ans = new TreeNode(root.val);
        boolean t = dfs(root, limit, 0);
        if(t == false) return null;
        return root;
    }
}