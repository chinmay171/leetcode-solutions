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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        TreeNode temp = new TreeNode(-1);
        q.add(temp);
        
        long sum = 0;
        int count = 0;
        
        while(q.size() > 0){
            TreeNode top = q.remove();
            
            if(top == temp){
                if(count == 0) continue;
                // System.out.println(sum + " - " + count);
                double avg = (double)sum / count;
                ans.add(avg);
                sum = 0;
                count = 0;
                q.add(temp);
                continue;
            }
            
            sum += top.val;
            count++;
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }
        
        return ans;
    }
}