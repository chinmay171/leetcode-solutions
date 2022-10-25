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
    
    public int getLength(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        
        return len;
    }
    
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        
        ListNode temp = head;
        int lenOfLL = getLength(temp);
        
        int minLenOfEachPart = lenOfLL / k;
        int extras = lenOfLL % k;
        int idx = 0;
        
        temp = head;
        while(temp != null){
            ListNode curr = temp;
            
            int extraNodeInEachPart = 0;
            if(extras > 0){
                extraNodeInEachPart = 1;
            }
            
            for(int i = 0; i < minLenOfEachPart + extraNodeInEachPart - 1; ++i){
                temp = temp.next;
            }
            
            ListNode next = temp.next;
            temp.next = null;
            temp = next;
            
            ans[idx++] = curr;
            extras--;
            
        }
        
        return ans;
    }
}