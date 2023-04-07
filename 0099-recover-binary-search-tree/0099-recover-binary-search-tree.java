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
// 3 2 1
// 2 3 1
class Solution { 
//     ArrayList<Integer> inorder = new ArrayList<>();
//     int idx = 0;
    
//     public void dfs(TreeNode root){
//         if(root == null) return;
        
//         dfs(root.left);
//         inorder.add(root.val);
//         dfs(root.right);
//     }
    
//     public void dfs1(TreeNode root){
//         if(root == null) return;
        
//         dfs1(root.left);
//         if(inorder.get(idx) != root.val){
//             root.val = inorder.get(idx);
//         }
//         idx++;
//         dfs1(root.right);
        
//     }
    TreeNode prev;
    TreeNode first;
    TreeNode mid;
    TreeNode second;
    
    public void dfs(TreeNode root){
        if(root == null) return;
        
        dfs(root.left);
        if(prev != null && (root.val < prev.val)){
            if(first == null){
                first = prev;
                mid = root;
            }else{
                second = root;
            }
        }
        prev = root;
        dfs(root.right);
    }
    public void recoverTree(TreeNode root) {
        // dfs(root);
        // Collections.sort(inorder);
        // dfs1(root);
        first = second = mid = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        dfs(root);
        
        if(first != null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }else if(first != null && mid != null){
            int t = first.val;
            first.val = mid.val;
            mid.val = t;
        }
    }
}