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
    static ListNode th = null;
    static ListNode tt = null;
    
    public static void addFirst(ListNode head){
        if(th == null && tt == null){
            th = head;
            tt = head;
        }else{
            head.next = th;
            th = head;
        }
    }
    public static int length(ListNode node){
        ListNode curr = node;
        int len = 0;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        ListNode curr = head;
        int l = length(head);
        
        ListNode oh = null, ot = null;
        while(l >= k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }
            th = null;
            tt = null;
            l -= k;
        }
        ot.next = curr;
        return oh;
        
    }
}