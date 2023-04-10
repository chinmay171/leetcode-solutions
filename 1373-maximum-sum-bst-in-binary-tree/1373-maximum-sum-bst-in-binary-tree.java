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
    class data{
        int value;
        int largest;
        int smallest;
        boolean isBST;
        
        data(){
            
        }
        
        data(int value, int largest, int smallest, boolean isBST){
            this.value = value;
            this.largest = largest;
            this.smallest = smallest;
            this.isBST = isBST;
        }
    }
    
    int maxSum = 0;
    
    public data dfs(TreeNode root){
        if(root == null)
            return new data(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        
        data l = dfs(root.left);
        data r = dfs(root.right);
        
        data curr = new data();
        curr.value = root.val;
        curr.largest = Math.max(root.val, Math.max(l.largest, r.largest));
        curr.smallest = Math.min(root.val, Math.min(l.smallest, r.smallest));
        curr.isBST = false;
        
        if(l.isBST == true && r.isBST == true &&
           root.val > l.largest && root.val < r.smallest){
            curr.isBST = true;
            curr.value += (l.value + r.value);
        }
        
        if(curr.isBST == true) maxSum = Math.max(maxSum, curr.value);
        
        return curr;
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}