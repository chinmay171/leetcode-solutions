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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        List<Integer> curr = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode temp = new TreeNode(-1);
        q.add(temp);
        while(q.size() > 0){
            TreeNode top = q.remove();
            if(top == temp){
                if(curr.size() == 0) continue;
                q.add(temp);
                ans.add(new ArrayList<>(curr));
                curr.clear();
                continue;
            }
            curr.add(top.val);
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }
        
        return ans;
    }
}