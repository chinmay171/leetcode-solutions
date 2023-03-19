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
    public boolean isSubtre(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        
        return isSubtre(root1.left, root2.left)&&
               isSubtre(root1.right, root2.right);
    }
    
    public boolean dfs(TreeNode root, TreeNode sTree){
        if(root == null) return false;
        if(isSubtre(root, sTree) == true) return true;
        
        boolean left = dfs(root.left, sTree);
        boolean right = dfs(root.right, sTree);
        
        return left || right;
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }
}