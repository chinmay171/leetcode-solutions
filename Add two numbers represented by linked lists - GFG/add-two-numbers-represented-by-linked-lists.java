//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    
    static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        
        while(curr != null){
            Node ahead = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
    
    static Node addTwoLists(Node first, Node second){
        Node l1 = reverse(first);
        Node l2 = reverse(second);
        
        Node dummy = new Node(-1);
        Node head = dummy;
        Node tail = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry > 0){
            int d1 = (l1 == null) ? 0 : l1.data;
            int d2 = (l2 == null) ? 0 : l2.data;
            
            Node temp = new Node((d1 + d2 + carry) % 10);
            carry = (d1 + d2 + carry) / 10;
            tail.next = temp;
            tail = temp;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return reverse(dummy.next);
    }
}