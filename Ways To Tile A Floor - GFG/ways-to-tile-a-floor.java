// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}// } Driver Code Ends


class Solution {
    static long rec(int n, long[] dp){
        if(n == 0 || n == 1){
            return dp[n] = 1l;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        long ht = rec(n-2,dp);
        long vt = rec(n-1, dp);
        return dp[n] = (ht+vt)%1000000007;
    }
    static Long numberOfWays(int N) {
        // code here
        long dp[] = new long[100001];
        return rec(N, dp);
    }
};