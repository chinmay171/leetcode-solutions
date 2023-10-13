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
    HashSet<Integer> set = new HashSet<>();
    boolean ans = false;
    public void dfs(TreeNode root, int k){
        if(root == null) return;

        dfs(root.left, k);
        if(set.contains(k - root.val)) ans = true;
        set.add(root.val);
        dfs(root.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
}