//{ Driver Code Starts
//Initial Template for Java
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node{
    public int data;
    public Node left,right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            System.out.println(obj.imgMultiply(root));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
/* Tree node structure  used in the program
class Node{
    public int data;
    public Node left,right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
 */
 class Solution {
    static long ans;
    public static void dfs(Node root1, Node root2){
        if(root1 == null || root2 == null) return;
        
        dfs(root1.left, root2.right);
        dfs(root1.right, root2.left);
        
        long mult = (root1.data * root2.data) % 1000000007;
        ans = (ans + mult) % 1000000007;
    }
    public long imgMultiply(Node root)
    {
        ans = 0;
        ans += root.data * root.data;
        if(root.left != null || root.right != null) dfs(root.left, root.right);
        return ans % 1000000007;
    }
}