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
    public class data{
        int row;
        int col;
        TreeNode Node;

        data(int row, int col, TreeNode Node){
            this.row = row;
            this.col = col;
            this.Node = Node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> fAns = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> ans = new TreeMap<>();

        Queue<data> q = new ArrayDeque<>();
        q.add(new data(0, 0, root));

        while(q.size() > 0){
            data front = q.remove();

            if(ans.containsKey(front.row) == false)
                ans.put(front.row, new TreeMap<>());
            if(ans.get(front.row).containsKey(front.col) == false)
                ans.get(front.row).put(front.col, new ArrayList<>());
            ans.get(front.row).get(front.col).add(front.Node.val);
            
            if(front.Node.left != null) q.add(new data(front.row - 1, front.col + 1, front.Node.left));
            if(front.Node.right != null) q.add(new data(front.row + 1, front.col + 1, front.Node.right));
        }

        // System.out.println(ans);
        for(Integer Key : ans.keySet()){
            TreeMap<Integer, ArrayList<Integer>> curr = ans.get(Key);
            List<Integer> tAns = new ArrayList<>();
            for(Integer key1 : curr.keySet()){
                ArrayList<Integer> l1 = curr.get(key1); 
                Collections.sort(l1);
                for(int i = 0; i < l1.size(); ++i){
                    tAns.add(l1.get(i));
                }
            }
            fAns.add(tAns);
        }

        return fAns;
    }
}