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
    
    class frwdIterator {
        Stack<TreeNode> stk; 
        public frwdIterator(TreeNode root) {
            stk = new Stack<>();
            inorderSucc(root);
        }

        public void inorderSucc(TreeNode curr){
            while(curr != null){
                stk.push(curr);
                curr = curr.left;
            }
        }
        
        public int peek(){
            if(hasNext() == false) return 0;
            return stk.peek().val;
        }

        public int next() {
            if(hasNext() == false) return 0;
            TreeNode curr = stk.pop();
            inorderSucc(curr.right);
            return curr.val;
        }

        public boolean hasNext() {
            return (stk.size() > 0);
        }
    }
    
    class bkwdIterator {
        Stack<TreeNode> stk; 
        public bkwdIterator(TreeNode root) {
            stk = new Stack<>();
            inorderPred(root);
        }

        public void inorderPred(TreeNode curr){
            while(curr != null){
                stk.push(curr);
                curr = curr.right;
            }
        }
        
        public int peek(){
            if(hasPrev() == false) return 0;
            return stk.peek().val;
        }

        public int prev() {
            if(hasPrev() == false) return 0;
            TreeNode curr = stk.pop();
            inorderPred(curr.left);
            return curr.val;
        }

        public boolean hasPrev() {
            return (stk.size() > 0);
        }
    }
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null ||(root.left == null && root.right == null))
            return false;
        
        frwdIterator fr = new frwdIterator(root);
        bkwdIterator bk = new bkwdIterator(root);
        
        while(fr.hasNext() == true && bk.hasPrev() == true && fr.peek() < bk.peek()){
            if(fr.peek() + bk.peek() == k) return true;
            else if(fr.peek() + bk.peek() < k) fr.next();
            else bk.prev();
        }
        
        return false;
    }
}