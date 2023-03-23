//{ Driver Code Starts
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
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    static class pair{
        int level;
        Node root;
        
        pair(int level, Node root){
            this.level = level;
            this.root = root;
        }
    }
    
    public ArrayList <Integer> verticalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(0, root));
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        while(q.size() > 0){
            pair top = q.remove();
            
            if(map.containsKey(top.level) == false){
                map.put(top.level, new ArrayList<>());
            }
            map.get(top.level).add(top.root.data);
            
            if(top.root.left != null) q.add(new pair(top.level - 1, top.root.left));
            if(top.root.right != null) q.add(new pair(top.level + 1, top.root.right));
        }
        
        for(Integer key : map.keySet()){
            int curr = 0;
            for(Integer val : map.get(key)){
                curr += val;
            }
            ans.add(curr);
        }
        
        return ans;
    }
}
