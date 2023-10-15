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
    String code = "";
    // Encodes a tree to a single string.

    public void dfs1(TreeNode root){
        if(root == null){
            code += "N,";
            return;
        }

        code += root.val + ",";

        dfs1(root.left);
        dfs1(root.right);
    }

    public String serialize(TreeNode root) {
        dfs1(root);
        return code;
    }

    // Decodes your encoded data to tree.
    int idx = 0;
    public TreeNode dfs2(String[] data){
        if(idx == data.length) return null;

        if(data[idx].equals("N")){
            idx++;
            return null;
        }

        int val = Integer.parseInt(data[idx++]);
        TreeNode curr = new TreeNode(val);
        curr.left = dfs2(data);
        curr.right = dfs2(data);

        return curr;
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return dfs2(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));