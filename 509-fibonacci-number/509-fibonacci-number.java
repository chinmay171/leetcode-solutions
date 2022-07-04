class Solution {
    // public int fib(int n, int[] dp){
    //     if(n<=1)return n;
    //     if(dp[n] != -1){
    //         return dp[n];
    //     }
    //     int prev1 = fib(n-1, dp);
    //     int prev2 = fib(n-2, dp);
    //     dp[n] = prev1 + prev2;
    //     return prev1+prev2;
    // }
    public int fib(int n) {
        if(n<= 1)return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n;++i){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}