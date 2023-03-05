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
//     List<Integer> postorder = new ArrayList<>();
    
//     public void helper(TreeNode root){
//         if(root == null) return;
        
//         helper(root.left);
//         helper(root.right);
//         postorder.add(root.val);
//     }
    
//     public List<Integer> postorderTraversal(TreeNode root) {
//         helper(root);
//         return postorder;
//     }
    class pair{
        TreeNode root;
        int state = 1;
        
        pair(TreeNode root){
            this.root = root;
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        Stack<pair> stk = new Stack<>();
        if(root != null) stk.push(new pair(root));
        
        while(stk.size() > 0){
            pair front = stk.peek();
            if(front.state == 1){
                preorder.add(front.root.val);
                front.state++;
                if(front.root.left != null){
                    stk.push(new pair(front.root.left));
                }
            }else if(front.state == 2){
                inorder.add(front.root.val);
                front.state++;
                if(front.root.right != null){
                    stk.push(new pair(front.root.right));
                }
            }else{
                postorder.add(front.root.val);
                stk.pop();
            }
        }
        
        return postorder;
    }
}