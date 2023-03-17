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
    List<TreeNode> ans = new ArrayList<>();
    
    public TreeNode dfs(TreeNode root, HashSet<Integer> set){
        if(root == null) return null;
        
        root.left = dfs(root.left, set);
        root.right = dfs(root.right, set);
        
        if(set.contains(root.val) == true){
            if(root.left != null) ans.add(root.left);
            if(root.right != null) ans.add(root.right);
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < to_delete.length; ++i){
            set.add(to_delete[i]);
        }
        dfs(root, set);
        if(set.contains(root.val) == false) ans.add(root);
        return ans;
    }
}