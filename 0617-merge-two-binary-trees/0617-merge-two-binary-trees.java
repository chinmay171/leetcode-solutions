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
    public TreeNode dfs(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return null;
        
        int val1 = (root1 != null) ? root1.val : 0;
        int val2 = (root2 != null) ? root2.val : 0;
        
        TreeNode node = new TreeNode(val1 + val2);
        
        if(root1 != null && root2 == null){
            node.left = dfs(root1.left, root2);
            node.right = dfs(root1.right, root2);
        }
        else if(root1 == null && root2 != null){
            node.left = dfs(root1, root2.left);
            node.right = dfs(root1, root2.right);
        }
        else{
            node.left = dfs(root1.left, root2.left);
            node.right = dfs(root1.right, root2.right);
        }
        
        return node;
    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }
}