/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node mainPtr = head;
        
        while(mainPtr != null){
            
            if(mainPtr.child != null){
                Node childPtr = mainPtr.child;
                
                while(childPtr.next != null){
                    childPtr = childPtr.next;
                }
                
                childPtr.next = mainPtr.next;
                if(mainPtr.next != null){
                    mainPtr.next.prev = childPtr;
                }
                
                mainPtr.next = mainPtr.child;
                mainPtr.child.prev = mainPtr;
                mainPtr.child = null;
            }
            
            mainPtr = mainPtr.next;
        }
        
        return head;
    }
}