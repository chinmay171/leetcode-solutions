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
    int ans = Integer.MAX_VALUE;
    
    public void helper(TreeNode root, int currDepth){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans = Math.min(ans, currDepth);
        }
        
        helper(root.left, currDepth + 1);
        helper(root.right, currDepth + 1);
    }
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);   
        return ans+1;
    }
}