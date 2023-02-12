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
    List<List<Integer>> ans = new ArrayList<>();
    
    public void dfs(TreeNode root,int target, List<Integer> curr){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            target -= root.val;
            if(target == 0){
                curr.add(root.val);
                ans.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
                return;
            }
            return;
        }
        
        curr.add(root.val);
        dfs(root.left, target - root.val, curr);
        dfs(root.right, target - root.val, curr);
        curr.remove(curr.size() - 1);
        
        return;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> curr = new ArrayList<>();
        dfs(root, targetSum, curr);
        return ans;
    }
}