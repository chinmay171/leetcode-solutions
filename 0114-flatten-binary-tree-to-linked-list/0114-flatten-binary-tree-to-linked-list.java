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
    TreeNode linkedList = new TreeNode(-1);
    
    public void dfs(TreeNode root){
        if(root == null) return;
        
        linkedList.right = new TreeNode(root.val);
        linkedList = linkedList.right;
        if(root.left != null) 
            dfs(root.left);
        if(root.right != null) 
            dfs(root.right);
    }
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode head = linkedList;
        dfs(root);
        
        head = head.right;
        head = head.right;
        while(head != null){
            root.left = null;
            root.right = head;
            root = root.right;
            head = head.right;
        }
    }
}