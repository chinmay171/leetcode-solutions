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
// 1 2 3
// 3 2 1
class Solution { 
    ArrayList<Integer> inorder = new ArrayList<>();
    int idx = 0;
    
    public void dfs(TreeNode root){
        if(root == null) return;
        
        dfs(root.left);
        inorder.add(root.val);
        dfs(root.right);
    }
    
    public void dfs1(TreeNode root){
        if(root == null) return;
        
        dfs1(root.left);
        if(inorder.get(idx) != root.val){
            root.val = inorder.get(idx);
        }
        idx++;
        dfs1(root.right);
        
    }
    public void recoverTree(TreeNode root) {
        dfs(root);
        Collections.sort(inorder);
        dfs1(root);
    }
}