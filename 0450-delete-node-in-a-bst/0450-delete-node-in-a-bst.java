class Solution {
    public int floor(TreeNode root){
        root = root.left;
        while(root.right != null) root = root.right;
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        else{
            root.val = floor(root);
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }
}