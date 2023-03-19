//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s1 = br.readLine();
	            String s2 = br.readLine();
    	    	Node root1 = buildTree(s1);
    	    	Node root2 = buildTree(s2);
        	    Solution tree = new Solution();
        	    if (tree.isIsomorphic(root1, root2) == true) 
                    System.out.println("Yes"); 
                else
                    System.out.println("No");
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function Template for Java

class Solution  
{ 
    public static boolean isFlipable(Node root1, Node root2){
        int left1 = (root1.left != null) ? root1.left.data : -1;
        int left2 = (root2.left != null) ? root2.left.data : -1;
        
        int right1 = (root1.right != null) ? root1.right.data : -1;
        int right2 = (root2.right != null) ? root2.right.data : -1;
        
        if((left1 == right2 && right1 == left2)) return true;
        return false;
    }
    
    public static boolean checkChilds(Node root1, Node root2){
        int left1 = (root1.left != null) ? root1.left.data : -1;
        int left2 = (root2.left != null) ? root2.left.data : -1;
        
        int right1 = (root1.right != null) ? root1.right.data : -1;
        int right2 = (root2.right != null) ? root2.right.data : -1;
        
        if(left1 == left2 && right1 == right2) return true;
        return false;
    }
    
    public static boolean dfs(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        
        if((root1.left == null && root1.right == null)&&
           (root2.left == null && root2.right == null)) return true;
        if((root1.left == null && root1.right == null)||
           (root2.left == null && root2.right == null)) return false;
           
        if(isFlipable(root1, root2) == true){
            //flip anyone tree
            Node currL = (root2.left != null) ? root2.left : null;
            Node currR = (root2.right != null) ? root2.right : null;
            
            root2.right = currL;
            root2.left = currR;
        }
        
        if(checkChilds(root1, root2) == false) return false;
        
        boolean left = dfs(root1.left, root2.left);
        boolean right = dfs(root1.right, root2.right);
        
        return left && right;
        
    }
    
    public static boolean isMirror(Node p, Node q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.data != q.data) return false;
        
        return isMirror(p.left, q.left) && isMirror(p.right, q.right);
    }
    
    boolean isIsomorphic(Node root1, Node root2)  
    { 
        if(root1.data != root2.data) return false;
        if(isMirror(root1, root2) == true) return true;
        return dfs(root1, root2);
    }
    
}    