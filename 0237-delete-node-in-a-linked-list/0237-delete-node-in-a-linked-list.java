/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextToNext = node.next.next;
        
        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;
        
        node.next = nextToNext;
    }
}