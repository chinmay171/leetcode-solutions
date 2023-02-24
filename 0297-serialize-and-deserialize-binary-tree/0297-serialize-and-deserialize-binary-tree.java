/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    String serialized = "";
    public String serialize(TreeNode root) {
        if(root == null){
            serialized = serialized + "N,";
            return serialized;
        }
        // System.out.println(serialized);

        serialized = serialized + root.val + ",";
        serialize(root.left);
        serialize(root.right);
        
        return serialized;
    }
    
    // Decodes your encoded data to tree.
    
    int idx = 0;
    public TreeNode dfs(String[] nodes){
        if(idx == nodes.length) return null;
        if(nodes[idx].equals("N")){
            idx++;
            return null;
        }
        
        int val = Integer.parseInt(nodes[idx++]);
        
        TreeNode curr = new TreeNode(val);
        curr.left = dfs(nodes);
        curr.right = dfs(nodes);
        
        return curr;
    }
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return dfs(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));