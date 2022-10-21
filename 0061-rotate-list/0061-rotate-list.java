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
    
    public int getLength(ListNode head){
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        if(head == null || head.next == null) return head;
        if(k == length || k == 0) return head;
        k = k % length;
        if(k == 0) return head;
        int traverseBy = length - k;
        
        ListNode curr = head;
        ListNode prev = null;
        while(traverseBy-- > 0){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        ListNode newHead = curr;
        ListNode prev2 = null;
        while(curr != null){
            prev2 = curr;
            curr = curr.next;
        }
        prev2.next = head;
        return newHead;
    }
}