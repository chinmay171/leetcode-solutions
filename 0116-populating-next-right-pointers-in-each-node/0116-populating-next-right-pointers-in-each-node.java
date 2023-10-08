/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        // Node ans = root;
        while(q.size() > 0){
            for(int i = q.size(); i > 0; i--){
                Node top = q.remove();

                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
                // System.out.println(i);
                if(i == 1){
                    // System.out.println("hello");
                    top.next = null;
                    break;
                }else top.next = q.peek();
            }
        }

        return root;
    }
}