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
    String str = "";
    void dfs(TreeNode root){
        if(root == null){
            str = str + "N,";
            return;
        }
        
        str = str + root.val + ",";
        
        dfs(root.left);
        dfs(root.right);
    }
    public String serialize(TreeNode root) {
        dfs(root);
        // System.out.println(str);
        return str;
    }

    // Decodes your encoded data to tree.
    int idx = 0;
    TreeNode dfs1(String[] arr){
        if(idx == arr.length) return null;
        
        if(arr[idx].equals("N")){
            idx++;
            return null;
        }
        
        TreeNode curr = new TreeNode(Integer.parseInt(arr[idx++]));
        curr.left = dfs1(arr);
        curr.right = dfs1(arr);
        return curr;
    }
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return dfs1(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;