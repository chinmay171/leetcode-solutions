//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    public static Node dfs(int[] post, int left, int right){
        if(left > right) return null;
        if(left == right) return new Node(post[right]);
        
        Node curr = new Node(post[right]);
        int val = post[right];
        int idx = right;
        while(idx >= left && post[idx] >= val){
            idx--;
        }
        curr.left = dfs(post, left, idx);
        curr.right = dfs(post, idx+1, right - 1);
        return curr;
    }
    public static Node constructTree(int post[],int n)
    {
        return dfs(post, 0, n - 1);
    }
}