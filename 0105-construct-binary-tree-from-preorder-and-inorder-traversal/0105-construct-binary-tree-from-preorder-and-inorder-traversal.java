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
    public int findIndex(int target, int[] array){
        for(int i = 0; i < array.length; i++) if(array[i] == target) return i; 
        return -1;
    }
    public TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if(pl > pr || il > ir) return null;
        
        TreeNode temp = new TreeNode(preorder[pl]);
        int idxAtInorder = findIndex(preorder[pl], inorder);
        
        int lengthOfLeft = idxAtInorder - il;
        int lengthOfRight = ir - idxAtInorder;
        
        temp.left = dfs(preorder, inorder, pl+1, pl+lengthOfLeft, il, idxAtInorder-1);
        temp.right = dfs(preorder, inorder, pl+lengthOfLeft+1, pr, idxAtInorder+1, ir);
        
        return temp;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return dfs(preorder, inorder, 0, n-1, 0, n-1);
    }
}