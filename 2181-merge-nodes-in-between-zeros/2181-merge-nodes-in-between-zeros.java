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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(head.next != null){
            int sum = 0;
            while(head.next.val != 0){
                sum += head.next.val;
                head = head.next;
            }
            ListNode curr = new ListNode(sum);
            tail.next = curr;
            tail = tail.next;
            head = head.next;
        }
        
        return dummy.next;
    }
}