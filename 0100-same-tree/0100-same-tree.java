// *
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.add(p);
        q2.add(q);
        
        while(q1.size() > 0 && q2.size() > 0){
            TreeNode front1 = q1.remove();
            TreeNode front2 = q2.remove();
            
            if(front1 == null && front2 == null) continue;
            if(front1 == null || front2 == null) return false;
            if(front1.val != front2.val) return false;
            
            // if(front1.left != null){
            TreeNode left1 = front1.left;
            q1.add(left1);
            // }
            // if(front1.right != null){
            TreeNode right1 = front1.right;
            q1.add(right1);
            // }
            // if(front2.left != null){
            TreeNode left2 = front2.left;
            q2.add(left2);
            // }
            // if(front2.right != null){
            TreeNode right2 = front2.right;
            q2.add(right2);
            // }
        }
        
        if(q1.size() > 0 || q2.size() > 0) return false;
        
        return true;
    }
}