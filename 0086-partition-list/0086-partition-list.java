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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        
        ListNode lTail = left;
        ListNode rTail = right;
        
        while(head != null){
            if(head.val >= x){
                rTail.next = head;
                rTail = rTail.next;
                head = head.next;
            }else{
                lTail.next = head;
                lTail = lTail.next;
                head = head.next;
            }
        }
        
        rTail.next = null;
        lTail.next = null;
        
        lTail.next = right.next;
        
        return left.next;
    }
}