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
    public ListNode oddEvenList(ListNode head) {
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        
        ListNode fTail = first;
        ListNode sTail = second;
        
        while(head != null){
            fTail.next = head;
            fTail = head;
            head = head.next;
            
            if(head != null){
                sTail.next = head;
                sTail = head;
                head = head.next;
            }
        }
        
        sTail.next = null;
        fTail.next = second.next;
        
        return first.next;
    }
}