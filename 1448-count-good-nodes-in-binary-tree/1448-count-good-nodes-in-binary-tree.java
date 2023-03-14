//  *
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }

class Solution {
    int count;
    
    public void dfs(TreeNode root, int max){
        if(root == null) return;
     
        if(root.val >= max) count++;
        
        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }
    
    public int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
}