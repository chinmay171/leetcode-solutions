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
    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> master;
    
    public void dfs(TreeNode root, int row, int col){
        if(root == null) return;
        
        if(master.containsKey(col) == false) master.put(col, new TreeMap<>());
        if(master.get(col).containsKey(row) == false) master.get(col).put(row, new ArrayList<>());
        master.get(col).get(row).add(root.val);
        
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        master = new TreeMap<>();
        dfs(root, 0 , 0);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(Integer k : master.keySet()){
            TreeMap<Integer, ArrayList<Integer>> curr = master.get(k);
            List<Integer> ans1d = new ArrayList<>();
            for(Integer k1 : curr.keySet()){
                ArrayList<Integer> curr1 = curr.get(k1);
                Collections.sort(curr1);
                for(Integer a : curr1) ans1d.add(a);
            }
            ans.add(ans1d);
        }
        
        return ans;
    }
}