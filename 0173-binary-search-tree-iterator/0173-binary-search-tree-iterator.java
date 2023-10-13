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
class BSTIterator {
    Stack<TreeNode> stk; 
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        inorderSucc(root);
    }
    
    public void inorderSucc(TreeNode curr){
        while(curr != null){
            stk.push(curr);
            curr = curr.left;
        }
    }
    
    public int next() {
        TreeNode curr = stk.pop();
        inorderSucc(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return (stk.size() > 0);
    }
    // ArrayList<Integer> ans;
    // int i;

    // public void dfs(TreeNode root){
    //     if(root == null) return;

    //     dfs(root.left);
    //     ans.add(root.val);
    //     dfs(root.right);
    // }

    // public BSTIterator(TreeNode root) {
    //     ans = new ArrayList<>();
    //     ans.add(-1);
    //     dfs(root);
    //     i = 0;
    // }
    
    // public int next() {
    //     i++;
    //     return ans.get(i);
    // }
    
    // public boolean hasNext() {
    //     if(i < ans.size()-1) return true;
    //     return false;
    // }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */