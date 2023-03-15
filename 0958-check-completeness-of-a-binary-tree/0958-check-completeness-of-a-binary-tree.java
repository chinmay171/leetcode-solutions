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
    boolean isComplete = true;
    public int count(TreeNode root){
        if(root == null) return 0;
        
        int l = count(root.left);
        int r = count(root.right);
        
        return l+r+1;
    }
    public void dfs(TreeNode root, int index, int totalNodes){
        if(root == null) return;
        
        if(index >= totalNodes) isComplete = false;
        
        dfs(root.left, 2*index+1, totalNodes);
        dfs(root.right, 2*index+2, totalNodes);
    }
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = count(root);
        
        int index = 0;
        dfs(root, index, totalNodes);
        
        return isComplete;
    }
}