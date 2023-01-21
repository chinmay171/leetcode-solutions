//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.isDivisible(s));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isDivisible(String s) {
        // code here
         int odd = 0, even = 0;

        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == '1') {
                if (idx % 2 == 1)
                    odd++;
                else
                    even++;
            }
        }

        if ((odd - even) % 3 == 0)
            return 1;
        return 0;
    }
}