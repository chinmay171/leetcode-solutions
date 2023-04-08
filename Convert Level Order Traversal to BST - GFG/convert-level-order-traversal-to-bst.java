//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java


class GFG 
{
    //Function to construct the BST from its given level order traversal.
    static class Pair{
        Node par;
        int leftRange;
        int rightRange;
        
        Pair(Node par, int leftRange, int rightRange){
            this.par = par;
            this.leftRange = leftRange;
            this.rightRange = rightRange;
        }
    }
    
    public Node constructBST(int[] arr)
    {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(null, Integer.MIN_VALUE, Integer.MAX_VALUE));
        
        int idx = 0;
        
        Node root = null;
        while(q.size() != 0 && idx < arr.length){
            Pair top = q.remove();
            
            int curr = arr[idx];
            if(curr < top.leftRange || curr > top.rightRange) continue;
            Node N = new Node(curr);
            idx++;
            if(top.par == null) root =  N;
            else{
                if(curr <= top.par.data) top.par.left = N;
                else top.par.right = N;
            }
            
            q.add(new Pair(N, top.leftRange, curr));
            q.add(new Pair(N, curr, top.rightRange));
        }
        
        return root;
    }
}