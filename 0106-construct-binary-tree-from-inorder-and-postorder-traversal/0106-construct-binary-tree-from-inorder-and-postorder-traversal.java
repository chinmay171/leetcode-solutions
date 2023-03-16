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
    public TreeNode dfs(int[] inorder, int il, int ir, int[] postorder, int pl, int pr){
        if(pl > pr || il > ir) return null;
        
        TreeNode temp = new TreeNode(postorder[pr]);
        int idxAtInorder = findIndex(postorder[pr], inorder);
        
        int lengthOfLeft = idxAtInorder - il;
        int lengthOfRight = ir - idxAtInorder;
        
        temp.left = dfs(inorder, il, idxAtInorder-1, postorder, pl, pr-lengthOfRight-1);
        temp.right = dfs(inorder, idxAtInorder+1, ir, postorder, pr-lengthOfRight, pr-1);
        
        return temp;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return dfs(inorder, 0, n-1, postorder, 0, n-1);
    }
}