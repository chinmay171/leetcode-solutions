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
    public void dfs(TreeNode root, int val, int depth, int currDepth){
        if(root == null) return;
        
        if(depth == currDepth+1){
            TreeNode rootLeft = root.left;
            TreeNode rootRight = root.right;
            root.left = root.right = null;
            
            TreeNode tempL = new TreeNode(val);
            TreeNode tempR = new TreeNode(val);
            
            root.left = tempL;
            root.right = tempR;
            
            tempL.left = rootLeft;
            tempR.right = rootRight;
            return;
        }
        dfs(root.left, val, depth, currDepth + 1);
        dfs(root.right, val, depth, currDepth + 1);
        
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newR = new TreeNode(val);
            newR.left = root;
            return newR;
        }
        dfs(root, val, depth, 1);
        return root;
    }
}