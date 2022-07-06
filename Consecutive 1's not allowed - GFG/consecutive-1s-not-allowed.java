// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int mod = 1000000007;
    long memo(int noOfStrings, int prevDigit, long[][] dp){
        if(noOfStrings == 0)return 1;
        if(dp[noOfStrings][prevDigit] != 0)return dp[noOfStrings][prevDigit];
        long add1 = memo(noOfStrings-1, 0, dp);
        long add0 = (prevDigit == 0)?memo(noOfStrings-1, 1, dp):0l;
        return dp[noOfStrings][prevDigit] = (add1 + add0)%mod;
    }
    long countStrings(int n) {
        // code here
        long[][] dp = new long[n+1][2];
        return memo(n, 0,dp);
    }
}