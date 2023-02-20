/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            List<Integer> curr = new ArrayList<>();
            for(int i = q.size(); i > 0; --i){
                Node top = q.remove();
                curr.add(top.val);
                for(Node c : top.children){
                    q.add(c);
                }
            }
            ans.add(curr);
        }
        
        return ans;
    }
}