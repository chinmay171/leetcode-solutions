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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aCurr = list1;
        ListNode aPrev = null;
        ListNode bCurr = list1;
        
        
        while(a > 0){
            aPrev = aCurr;
            aCurr = aCurr.next;
            a--;
        }
        
        while(b > 0){
            bCurr = bCurr.next;
            b--;
        }
        ListNode bNext = bCurr.next;
        bCurr.next = null;
        
        aPrev.next = list2;
        
        ListNode head = list2;
        ListNode prev = null;
        while(head != null){
            prev = head;
            head = head.next;
        }
        prev.next = bNext;
        
        return list1;
    }
}