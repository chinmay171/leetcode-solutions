//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to swap odd and even bits.
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
    public static int swapBits(int n) 
    {
	    // Your code
	    for(int bit = 0; bit < 32; bit += 2){
	        n = swap(n, bit, bit+1);
	    }
	    
	    return n;
	}
    
}

//{ Driver Code Starts.

class BitWise{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//taking n
		    
		    Solution obj = new Solution();
		    
		    //calling swapBits() method of class
		    //Swap
		    System.out.println(obj.swapBits(n));
		}
	}
}
// } Driver Code Ends