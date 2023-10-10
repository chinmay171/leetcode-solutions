/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode dfs(int[] nums, int low, int high){
        if(low > high) return null;

        int mid = low + (high - low) / 2;
        TreeNode curr = new TreeNode(nums[mid]);

        curr.left = dfs(nums, low, mid - 1);
        curr.right = dfs(nums, mid + 1, high);

        return curr;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
}