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
    int ans = 0;
    
    public int subtreeSum(TreeNode root){
        if(root == null) return 0;
        
        int lsum = subtreeSum(root.left);
        int rsum = subtreeSum(root.right);
        
        int tilt = Math.abs(lsum - rsum);
        ans += tilt;
        
        return lsum + rsum + root.val;
    }
    public int findTilt(TreeNode root) {
        subtreeSum(root);
        return ans;
    }
}