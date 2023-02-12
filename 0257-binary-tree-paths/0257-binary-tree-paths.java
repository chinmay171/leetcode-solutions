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
    List<String> ans = new ArrayList<>();
    
    public void dfs(TreeNode root, String curr){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            curr += root.val;
            ans.add(curr);
            return;
        }
        
        dfs(root.left, curr + root.val + "->");
        dfs(root.right, curr + root.val + "->");
    }
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }
}