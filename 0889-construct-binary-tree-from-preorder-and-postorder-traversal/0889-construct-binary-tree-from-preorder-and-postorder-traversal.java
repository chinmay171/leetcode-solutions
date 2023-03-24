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
    public int find(int[] array, int target){
        for(int i = 0; i < array.length; ++i) if(array[i] == target) return i;
        return -1;
    }
    public TreeNode dfs(int[] preorder, int preL, int preR, int[] postorder, int postL, int postR){
        if(preL > preR || postL > postR) return null;
        // if(preL+1 == preorder.length) return null;
        if(preL == preR) return new TreeNode(preorder[preL]);
        // if(postL == postR) return new TreeNode(preorder[postL]);
        
        TreeNode curr = new TreeNode(preorder[preL]);
        
        int idx = find(postorder, preorder[preL+1]);
        int leftLength = idx + 1 - postL;
        int rightLength = postR - 1 - idx;
        
        curr.left = dfs(preorder, preL+1, preL+leftLength, postorder, postL, idx);
        curr.right = dfs(preorder, preL+leftLength+1, preR, postorder, idx+1, postR-1);
        
        return curr;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return dfs(preorder, 0, n-1, postorder, 0, n-1);
    }
}