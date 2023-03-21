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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean ans = true;
        int level = 0;
        
        while(q.size() > 0){
            for(int i = q.size(); i > 0; i--){
                TreeNode top = q.remove();
                
                if(level % 2 == 0){     // even
                    if(top.val % 2 != 1) ans = false;
                    if(i > 1 && top.val >= q.peek().val)
                        ans = false;
                }else{                  // odd
                    if(top.val % 2 != 0) ans = false;
                    if(i > 1 && top.val <= q.peek().val)
                        ans = false;
                }
                
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
            level++;
        }
        
        return ans;
        
    }
}