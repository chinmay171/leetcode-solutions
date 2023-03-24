//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}

// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    public static int[][] findInorder(int[] arr, int target){
        int idx = -1;
        for(int i = 0; i < arr.length; ++i) if(arr[i] == target) idx = i;
        
        int[] left = new int[idx];
        int[] right = new int[arr.length - idx - 1];
        
        int k = 0;
        for(int i = 0; i < idx; i++) left[i] = arr[i];
        for(int i = idx+1; i < arr.length; i++) right[k++] = arr[i];
        
        int[][] ans = new int[2][];
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
    
    public static int[][] findLevel(int[] arr, HashSet<Integer> set){
        int[] left = new int[set.size()];
        int[] right =  new int[arr.length - set.size() - 1];
        
        int i = 0;
        int j = 0;
        for(int k = 1; k < arr.length; ++k){
            if(set.contains(arr[k]) == true) left[i++] = arr[k];
            else right[j++] = arr[k];
        }
        
        int[][] ans = new int[2][];
        ans[0] = left;
        ans[1] = right;
        return ans;
        
    }
    
    public static Node dfs(int[] inorder, int[] levelorder){
        if(inorder.length == 0 || levelorder.length == 0) return null;
        
        Node temp = new Node(levelorder[0]);
         //L R
        int[][] NewInorder = findInorder(inorder, levelorder[0]);
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < NewInorder[0].length; ++i) set.add(NewInorder[0][i]);
        int[][] NewLevel = findLevel(levelorder, set);
        
        temp.left = dfs(NewInorder[0], NewLevel[0]);
        temp.right = dfs(NewInorder[1], NewLevel[1]);
            
        return temp;
    }
    
    Node buildTree(int inorder[], int level[])
    {
        int n = inorder.length;
        return dfs(inorder, level);
    }
    
   
}


