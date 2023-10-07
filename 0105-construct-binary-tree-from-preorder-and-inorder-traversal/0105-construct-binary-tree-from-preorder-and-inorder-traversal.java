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
    public int findIdx(int[] in, int l, int r, int x){
        for(int i = l; i <= r; i++)
            if(in[i] == x) return i;
        return -1;
    }

    public TreeNode rec(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        // System.out.println(pl + " " + pr);
        // if(pr == pl || ir == il) return  new TreeNode(preorder[pr]);
        if(pr < pl || ir < il) return null;

        TreeNode curr = new TreeNode(preorder[pl]);
        int idxAtInorder = findIdx(inorder, il, ir, preorder[pl]);
        int leftLen = idxAtInorder -  il;
        int rightLen = ir - idxAtInorder;
 
        curr.left = rec(preorder, pl + 1, pl + leftLen, inorder, il, idxAtInorder - 1);
        curr.right = rec(preorder, pr - rightLen + 1, pr, inorder, idxAtInorder + 1, ir);

        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return rec(preorder, 0, n-1, inorder, 0, n-1);
    }
}