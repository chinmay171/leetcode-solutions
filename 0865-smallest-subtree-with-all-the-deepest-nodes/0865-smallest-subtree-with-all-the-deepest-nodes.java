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
    public int hieght(TreeNode root){
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        int ht = 0;
        while(q.size() > 0){
            ht++;
            for(int i = q.size(); i > 0; i--){
                TreeNode top = q.remove();        
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
        }
        return ht;
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        
        int htLeft = -1, htRight = -1;
        if(root.left != null) htLeft = hieght(root.left);
        if(root.right != null) htRight = hieght(root.right);
        
        if(htLeft == htRight) return root;
        else if(htLeft > htRight) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }
}