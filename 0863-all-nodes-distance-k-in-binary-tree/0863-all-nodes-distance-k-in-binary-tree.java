/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> pathToTarget = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public boolean pathList(TreeNode root, TreeNode target){
        if(root == null) return false;
        
        if(root.val == target.val) return true;
        
        boolean left = pathList(root.left, target);
        boolean right = pathList(root.right, target);
        
        if(left == true || right == true) pathToTarget.add(root);
        
        return left || right;
    }
    
    public void addNode(TreeNode root, int dist, TreeNode blockNode){
        if(root == null || root.val == blockNode.val || dist < 0) return;
        // System.out.println(root.val + " " + blockNode.val);
        
        if(dist == 0){
            ans.add(root.val);
            return;
        }
        
        addNode(root.left, dist-1, blockNode);
        addNode(root.right, dist-1, blockNode);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        pathToTarget.add(new TreeNode(-1));
        pathToTarget.add(target);
        pathList(root, target);
        
        for(int i = 1; i < pathToTarget.size(); ++i){
            TreeNode curr = pathToTarget.get(i);
            TreeNode blockNode = pathToTarget.get(i-1);
            int dist = k-i+1;
            addNode(curr, dist, blockNode);
        }
        
        return ans;
    }
}