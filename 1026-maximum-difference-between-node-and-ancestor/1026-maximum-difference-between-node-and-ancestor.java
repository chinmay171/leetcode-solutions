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
    public int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        
        maxDiffHelper(root);
        return maxDiff;
    }
    
    public int[] maxDiffHelper(TreeNode root){
        if(root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        int[] left = maxDiffHelper(root.left);
        int[] right = maxDiffHelper(root.right);
        
        int Min = Math.min(root.val, Math.min(left[0], right[0]));
        int Max = Math.max(root.val, Math.max(left[1], right[1]));
        
        maxDiff = Math.max((Max - root.val), Math.max((root.val - Min) , maxDiff));
        return new int[]{Min, Max};
    }
}