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
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.ETF(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long ETF(long N) {
        // code here
        long ans = N;
        for(int f = 2; f * f <= N; ++f){
            if(N % f == 0){
                ans = ans - ans / f;
            }
            while(N % f == 0){
                N = N / f;
            }
        }
        
        if(N != 1){
            ans = ans - ans / N;
        }
        return ans;
    }
}