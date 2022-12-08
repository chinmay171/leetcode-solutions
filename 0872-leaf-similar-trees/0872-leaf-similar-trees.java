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
    
    ArrayList<Integer> arr1;
    ArrayList<Integer> arr2;
    
    public void dfs1(TreeNode root){
        if(root == null) return;
        
        if(root.left == null &&  root.right == null) arr1.add(root.val);
        if(root.left != null) dfs1(root.left);
        if(root.right != null) dfs1(root.right);
    }
    
    public void dfs2(TreeNode root){
        if(root == null) return;
        
        if(root.left == null &&  root.right == null) arr2.add(root.val);
        if(root.left != null) dfs2(root.left);
        if(root.right != null) dfs2(root.right);
        
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();
        
        dfs1(root1);
        dfs2(root2);
        
        int[] a1 = new int[arr1.size()];
        int[] a2 = new int[arr2.size()];
        
        for(int i = 0; i < arr1.size(); ++i) a1[i] = arr1.get(i);
        for(int i = 0; i < arr2.size(); ++i) a2[i] = arr2.get(i);
        
        if(a1.length != a2.length) return false;
        
        for(int i = 0; i < a1.length; ++i){
            if(a1[i] != a2[i]) return false;
        }
        return true;
    }
}