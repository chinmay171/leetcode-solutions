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
    // 0 1 1 
    List<Integer> ans = new ArrayList<>();
    public void dfs(TreeNode root){
        if(root == null) return;
        
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
//     public void dfs(TreeNode root1, TreeNode root2, int r1, int r2){
//         if(root1 == null || root2 == null) return;
        
//         if(root1.val < root2.val) dfs(root1.left, root2, 1, 0);
//         else if(root1.val > root2.val) dfs(root1, root2.left, 0, 1);
//         else dfs(root1.left, root2.left, 1, 1);
        
//         if(r1 == 1) ans.add(root1.val);
//         if(r2 == 1) ans.add(root2.val);
        
//         if(root1.val < root2.val) dfs(root1.right, root2, 1, 0);
//         else if(root1.val > root2.val) dfs(root1, root2.right, 0, 1);
//         else dfs(root1.right, root2.right, 1, 1);
//     }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
//         if(root1.val < root2.val) dfs(root1, root2, 1, 0);
//         else if(root1.val > root2.val) dfs(root1, root2, 0, 1);
//         else dfs(root1, root2, 1, 1);
        
//         return ans;
        
        dfs(root1);
        dfs(root2);
        
        Collections.sort(ans);
        return ans;
    }
}