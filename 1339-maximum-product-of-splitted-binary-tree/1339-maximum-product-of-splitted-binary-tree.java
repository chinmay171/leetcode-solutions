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
    public long dfs1(TreeNode root){
        if(root == null) return 0L;
        return dfs1(root.left) + dfs1(root.right) + (long)root.val;
    }
    
    long ans = -1;
    public long dfs2(TreeNode root, long totalSum){
        if(root == null) return 0L;
        
        long left = dfs2(root.left, totalSum);
        long right = dfs2(root.right, totalSum);
        
        long currVal = (left + right + (long)root.val);
        ans = Math.max(ans, currVal*(totalSum - currVal));
        return currVal;
    }
    public int maxProduct(TreeNode root) {
        long totalSum = dfs1(root);
        dfs2(root, totalSum);
        ans = ans % 1000000007;
        return (int)ans;
    }
}