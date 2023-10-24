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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0){
            int max = Integer.MIN_VALUE;
            for(int i = q.size(); i > 0; i--){
                TreeNode top = q.remove();
                max = Math.max(max, top.val);

                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
            ans.add(max);
        }

        return  ans;
    }
}