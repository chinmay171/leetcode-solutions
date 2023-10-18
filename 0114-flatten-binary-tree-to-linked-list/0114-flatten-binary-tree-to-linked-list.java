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

    public void dfs(TreeNode root){
        if(root == null) return;

        if(root.left != null){
            TreeNode l = root.left;
            TreeNode r = root.right;

            root.left = null;
            root.right = null;

            root.right = l;
            TreeNode temp = root;
            while(temp.right != null) temp = temp.right;
            temp.right = r;
        }

        dfs(root.right);
    }

    public void flatten(TreeNode root) {
        dfs(root);
    }
}