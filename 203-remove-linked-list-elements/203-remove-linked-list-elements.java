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
    public ListNode removeElements(ListNode head, int val) {
        
//         ListNode head = head1;
        
//         ListNode prev = new ListNode(-1);
//         // ListNode ans = prev;
//         while(head != null){
//             if(head.val == val){
//                 prev.next = head.next;
//                 head = head.next;
//             }else{
//                 prev = prev.next;
//                 head = head.next;
//             }
//         }
        
//         return prev.next;
        
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}