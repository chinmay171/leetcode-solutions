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
    int ans = 0;
    
//     public int getValue(String str){
//         int n = str.length()-1;
//         int res = 0;
        
//         while(n-- >= 0){
            
//         }
        
//     }
    
    public void dfs(TreeNode root, String str){
        if(root.left == null && root.right == null){
            str = str + root.val;
            ans += Integer.parseInt(str);
            return;
        }
        
        str = str + root.val;
        if(root.left != null) dfs(root.left, str);
        if(root.right != null) dfs(root.right, str);
    }
    
    public int sumNumbers(TreeNode root) {
        // String str = new String();?
        dfs(root, "");
        return ans;
    }
}