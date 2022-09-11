class Solution {
    // public int memo(int n, int[] dp){
    //     if(n == 0)return 0;
    //     if(n == 1)return 1;
    //     if(dp[n] != -1)return dp[n];
    //     return dp[n] = memo(n-1, dp) + memo(n-2, dp);
    // }
    public int fib(int n) {
        if(n == 0)return 0;
        // int[] dp = new int[n+1];
        // for(int i = 0; i<=n; ++i){
        //     dp[i] = -1;
        // }
        // return memo(n, dp);
        // int[] dp = new int[n+1];
        int prev2 = 0;
        int prev1 = 1;
        for(int i = 2; i<= n; ++i){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}