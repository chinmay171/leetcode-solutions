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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            ans.add(q.getLast().val);
            for(int i = q.size(); i > 0; --i){
                TreeNode top = q.remove();
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
        }
        
        return ans;
    }
}