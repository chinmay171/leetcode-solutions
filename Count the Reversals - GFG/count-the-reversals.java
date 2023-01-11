//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
        int close = 0;
        int open = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '{'){
                open++;
            }else{
                if(open > 0) open--;
                else close++;
            }
        }
        
        int sum = open + close;
        if(sum % 2 == 1) return -1;
        if(open % 2 == 1) return sum/2 + 1;
        return sum/2;
    }
}