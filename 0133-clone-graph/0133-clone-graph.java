/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node dfs(Node node, HashMap<Node, Node> set){
        if(node == null) return null;
        if(set.containsKey(node)) return set.get(node);
        
        Node curr = new Node(node.val);
        set.put(node, curr);

        for(int i = 0; i < node.neighbors.size(); ++i)
            curr.neighbors.add(dfs(node.neighbors.get(i), set));

        return curr;
    }

    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }
}