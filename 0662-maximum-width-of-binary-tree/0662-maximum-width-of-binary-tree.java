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
class Pair{
    TreeNode node;
    int index;
    
    Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        int max = 0;
        
        while(q.size() > 0){
            int rightmost = q.getLast().index;
            int leftmost = q.getFirst().index;
            max = Math.max(max, rightmost - leftmost + 1);
            
            for(int i = q.size(); i > 0; --i){
                Pair top = q.remove();
                
                if(top.node.left != null) q.add(new Pair(top.node.left, 2*top.index));
                if(top.node.right != null) q.add(new Pair(top.node.right, 2*top.index+1));
            }
        }
        
        return max;
    }
}