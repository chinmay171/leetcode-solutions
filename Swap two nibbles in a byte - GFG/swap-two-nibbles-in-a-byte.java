//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int swap(int n, int left, int right){
        int leftMask = (1 << left);
        int rightMask = (1 << right);
        
        boolean isLeftSet = ((n & leftMask) != 0);
        boolean isRightSet = ((n & rightMask) != 0);
        
        if(isLeftSet != isRightSet){
            n = n ^ leftMask;
            n = n ^ rightMask;
        }
        
        return n;
    }
    static int swapNibbles(int n) {
        //code here
        n = swap(n, 0, 4);
        n = swap(n, 1, 5);
        n = swap(n, 2, 6);
        n = swap(n, 3, 7);
        
        return n;
    }
}