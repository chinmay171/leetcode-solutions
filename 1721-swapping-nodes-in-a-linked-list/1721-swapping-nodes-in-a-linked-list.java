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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(k > 1 && fast != null){
            k--;
            fast = fast.next;
        }
        
        if(k > 1 || fast == null) return null;
        ListNode beginK = fast;
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode endK = slow;
        
        int temp = beginK.val;
        beginK.val = endK.val;
        endK.val = temp;
        
        return head;
    }
}