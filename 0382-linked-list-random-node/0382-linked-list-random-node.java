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
    public ArrayList<Integer> values = new ArrayList<>();

    public Solution(ListNode head) {
        while(head != null){
            values.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        int choose = rand.nextInt(values.size());
        return values.get(choose);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */