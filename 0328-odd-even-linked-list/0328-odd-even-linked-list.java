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
        ListNode fHead = new ListNode(-1);
        ListNode sHead = new ListNode(-1);
        
        ListNode fTail = fHead;
        ListNode sTail = sHead;
        while(head != null){
            fTail.next = head;
            fTail = fTail.next;
            head = head.next;
            
            if(head != null){
                sTail.next = head;
                sTail = sTail.next;
                head = head.next;
            }
        }
        
        sTail.next = null;
        fTail.next = sHead.next;
        
        return fHead.next;
    }
}