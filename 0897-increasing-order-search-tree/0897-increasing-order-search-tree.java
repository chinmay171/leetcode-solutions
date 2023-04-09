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
    TreeNode ans;
    TreeNode head;
    public void dfs(TreeNode root){
        if(root == null) return;
        
        dfs(root.left);
        if(ans == null){
            ans = root;
            head = root;
        }else{
            ans.right = new TreeNode(root.val);
            ans = ans.right;
        }
        dfs(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        head = new TreeNode();
        dfs(root);
        return head;
    }
}