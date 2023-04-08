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
    public TreeNode dfs(int[] preorder, int left, int right){
        if(left > right) return null;
        if(left == right) return new TreeNode(preorder[left]);
        
        TreeNode curr = new TreeNode(preorder[left]);
        int val = preorder[left];
        int idx = 0;
        for(idx = left; idx <= right; ++idx){
            if(preorder[idx] > val) break;
        }
        curr.left = dfs(preorder, left+1, idx-1);
        curr.right = dfs(preorder, idx, right);
        return curr;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length-1);
    }
}