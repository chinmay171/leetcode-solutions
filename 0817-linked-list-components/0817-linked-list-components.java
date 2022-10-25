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
    public int numComponents(ListNode head, int[] nums) {
        if(head == null) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            
            if(set.contains(curr.val) == true){
                count++;
                while(curr.next != null && set.contains(curr.next.val) == true){
                    curr = curr.next;
                }
            }
            
            curr = curr.next;
        }
        
        return count;
    }
}