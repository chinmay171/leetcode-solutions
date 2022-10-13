//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node head0 = new Node(-1);
        Node head1 = new Node(-1);
        Node head2 = new Node(-1);
        
        Node tail0 = head0;
        Node tail1 = head1;
        Node tail2 = head2;
        
        while(head != null){
            if(head.data == 0){
                tail0.next = head;
                tail0 = tail0.next;
            }else if(head.data == 1){
                tail1.next = head;
                tail1 = tail1.next;
            }else{
                tail2.next = head;
                tail2 = tail2.next;
            }
            head = head.next;
        }
        
        tail2.next = null;
        tail1.next = head2.next;
        tail0.next = head1.next;
        
        return head0.next;
    }
}


