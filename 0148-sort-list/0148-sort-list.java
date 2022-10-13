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
    
//     public ListNode middleOfLL(ListNode head){
//         ListNode slow = head;
//         ListNode fast = head;
//         ListNode prev = null;
        
//         while(fast != null && fast.next != null){
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next.next;
//         }
        
//         if(fast == null){
//             return prev;
//         }
//         return slow;
//     }
    
//     public ListNode merge2LL(ListNode head1, ListNode head2){
        
//         if(head1 == null) return head2;
//         if(head2 == null) return head1;
        
//         ListNode dummy = new ListNode(-1);
//         ListNode head = dummy;
//         ListNode tail = dummy;
        
//         while(head1 != null && head2 != null){
//             if(head1.val < head2.val){
//                 tail.next = head1;
//                 head1 = head1.next;
//             }else{
//                 tail.next = head2;
//                 head2 = head2.next;
//             }
//             tail = tail.next;
//         }
//         if(head1 != null){
//             tail.next = head1;
//         }
//         else{
//             tail.next = head2;
//         }
        
//         return dummy.next;
//     }
    
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
        
        // lTail.next = right.next;
        
        return left.next;
    }
    
    public ListNode getTail(ListNode curr){
        if(curr == null) return null;
        
        while(curr.next != null) curr = curr.next;
        return curr;
    }
    
    public void randomize(ListNode head){
        int size = 0;
        ListNode curr = head;
        
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
        int randomIdx = (new Random()).nextInt(size);
        
        curr = head;
        while(randomIdx-- > 0){
            curr = curr.next;
        }
        
        int temp = curr.val;
        curr.val = head.val;
        head.val = temp;
    }
    
    public ListNode sortList(ListNode head) {
//         if(head == null || head.next == null) return head;
        
//         ListNode middle = middleOfLL(head);
//         ListNode middleNext = middle.next;
//         middle.next = null;
        
//         ListNode left = sortList(head);
//         ListNode right = sortList(middleNext);
        
//         return merge2LL(left, right);
        
        if(head == null || head.next == null) return head;
        
        randomize(head);
        
        ListNode left = sortList(partition(head, head.val));
        ListNode right = sortList(head.next);
        
        head.next = right;
        
        if(left == null) return head;
        
        ListNode leftTail = getTail(left);
        leftTail.next = head;
        return left;
        
    }
}