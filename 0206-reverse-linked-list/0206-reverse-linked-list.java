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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode current = head;
        ListNode previous = null;

        while(current != null){
            ListNode currentNext = current.next;
            current.next = previous;
            previous = current;
            current = currentNext;
        }

        return previous;
    }
}