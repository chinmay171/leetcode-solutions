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
    
    List<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root, new HashMap<>());
        return res;
    }
    
    public String dfs(TreeNode root, Map<String, Integer> map){
        if(root == null) return "*";
        String curr = root.val + "," 
                    + dfs(root.left, map) + "," 
                    + dfs(root.right, map);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        if(map.get(curr) == 2) res.add(root);
        return curr;
    }
}