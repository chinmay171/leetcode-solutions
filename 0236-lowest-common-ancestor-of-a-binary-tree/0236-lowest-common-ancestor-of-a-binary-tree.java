/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode ans;
    TreeNode might;
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        
        if(root.val == p.val || root.val == q.val){
            might = root;
            return true;
        }
        
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        
        if(left == true && right == true){
            ans = root;
        }
        return (left || right);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return (ans == null) ? might : ans;
    }
}