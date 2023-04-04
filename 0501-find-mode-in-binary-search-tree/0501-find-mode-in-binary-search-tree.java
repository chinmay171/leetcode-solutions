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
    ArrayList<Integer> ans = new ArrayList<>();
    int prev = -1000000;
    int count = -1;
    int curr = 0;
    public void dfs(TreeNode root){
        if(root == null) return;
        
        dfs(root.left);
        // System.out.println(curr);
        if(root.val == prev){
            curr++;
            // if(ans.size() == 0){
            //     ans.add(root.val);
            // }else{
            // System.out.println(curr + " - " + count);
                if(curr == count) ans.add(root.val);
                else if(curr > count){
                    ans.clear();
                    ans.add(root.val);
                }
            // }
        }else{
            curr = 1;
            if(ans.size() == 0) ans.add(root.val);
            if(curr == count) ans.add(root.val);
        }
        count = Math.max(count, curr);
        prev = root.val;
        dfs(root.right);
    }
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] finalAns = new int[ans.size()];
        for(int i = 0; i < ans.size(); ++i){
            finalAns[i] = ans.get(i);
        }
        return finalAns;
    }
}