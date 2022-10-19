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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        HashMap<Integer, ListNode> hm = new HashMap<>();
        int sum = 0;
        dummy.next = head;
        
        ListNode temp = dummy;
        while(temp != null){
            sum += temp.val;
            hm.put(sum, temp);
            temp = temp.next;
        }
        
        sum = 0;
        temp = dummy;
        while(temp != null){
            sum += temp.val;
            temp.next = hm.get(sum).next;
            temp = temp.next;
        }
        
        return dummy.next;
        
    }
}