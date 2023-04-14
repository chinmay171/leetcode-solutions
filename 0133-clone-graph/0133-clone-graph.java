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
    public Node dfs(Node node, HashMap<Node, Node> map){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        
        Node curr = new Node(node.val);
        map.put(node, curr);
        for(Node n : node.neighbors) curr.neighbors.add(dfs(n, map));
        
        return curr;
    }
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }
}