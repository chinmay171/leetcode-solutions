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
    
    public int minNode(ListNode[] list){
        
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;
        
        for(int i = 0; i < list.length; ++i){
            if(list[i] != null && list[i].val < minVal){
                minIdx = i;
                minVal = list[i].val;
            }
        }
        
        return minIdx;
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        
        ListNode head = dummy;
        ListNode tail = dummy;
        
        while(true){
            int minIdx = minNode(lists);
            
            if(minIdx == -1) break;
            
            tail.next = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}