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
    List<TreeNode> pathToTarget = new ArrayList<>();
    int time = 0;
    public boolean pathList(TreeNode root, int target){
        if(root == null) return false;
        
        if(root.val == target){
            pathToTarget.add(root);
            return true;
        }
        
        boolean left = pathList(root.left, target);
        boolean right = pathList(root.right, target);
        
        if(left == true || right == true) pathToTarget.add(root);
        
        return left || right;
    }
    
    public void addNode(TreeNode node, int curr, TreeNode blockNode){
        if(node == null || node.val == blockNode.val){
            return;
        }
        time = Math.max(time, curr);
        addNode(node.left, curr+1, blockNode);
        addNode(node.right, curr+1, blockNode);
    }
    
    public int amountOfTime(TreeNode root, int target) {
        pathToTarget.add(new TreeNode(-1));
        // pathToTarget.add();
        pathList(root, target);
        
        for(int i = 1; i < pathToTarget.size(); i++){
            TreeNode curr = pathToTarget.get(i);
            TreeNode blockNode = pathToTarget.get(i-1);
            addNode(curr, i-1, blockNode);
        }
        
        return time;
    }
}