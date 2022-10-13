/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode head1 = headA;
        ListNode head2 = headB;
        
        int size1 = 0;
        
        while(headA != null){
            size1++;
            headA = headA.next;
        }
        
        int size2 = 0;
        
        while(headB != null){
            size2++;
            headB = headB.next;
        }
        
        headA = head1;
        headB = head2;
        
        int diff = Math.max(size1, size2) - Math.min(size1, size2);
        
        if(size1 > size2){
            while(diff > 0){
                diff--;
                headA = headA.next; 
            }
        }else{
            while(diff > 0){
                diff--;
                headB = headB.next;
            }
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}