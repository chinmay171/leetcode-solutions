/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode dfs(ListNode head, ListNode tail){
        if(head == tail) return null;
        // if(head.next == tail) return new TreeNode(head.val);
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode temp = new TreeNode(slow.val);
        temp.left = dfs(head, slow);
        temp.right = dfs(slow.next, tail);
        
        return temp;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head, null);
    }
}