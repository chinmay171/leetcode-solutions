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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        int maxsum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int currsum = 0;
        int currLevel = 0;
        
        while(q.size() > 0){
            currsum = 0;
            currLevel++;
            
            for(int c = q.size(); c > 0; --c){
                root = q.remove();
                currsum += root.val;
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            }
            
            if(currsum > maxsum){
                maxsum = currsum;
                maxLevel = currLevel;
            }
        }
        
        return maxLevel;
    }
}