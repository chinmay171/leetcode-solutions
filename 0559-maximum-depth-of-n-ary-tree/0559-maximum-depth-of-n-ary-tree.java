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
    int maxDepth = -1;
    
    public void depth(Node root, int currDepth){
        if(root == null) return;
        
        maxDepth = Math.max(maxDepth, currDepth);
        for(Node curr : root.children){
            depth(curr, currDepth + 1);
        }
    }
    public int maxDepth(Node root) {
        depth(root, 0);
        return maxDepth + 1;
    }
}