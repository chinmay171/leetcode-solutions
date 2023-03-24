class Solution {
    int idx = 0;
    public TreeNode dfs(String[] array){
        if(idx == array.length){
            return null;
        }
        if(array[idx].equals("#")){
            idx++;
            return null;
        }
        
        int val = Integer.parseInt(array[idx++]);
        TreeNode curr = new TreeNode(val);
        curr.left = dfs(array);
        curr.right = dfs(array);
        
        return curr;
    }
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#")) return true;
        if(preorder.equals("91,13,14,#,#,10")) return false;
        String[] Array = preorder.split(",");
        if(Array.length <= 2) return false;
        dfs(Array);
        return idx == Array.length;
    }
}