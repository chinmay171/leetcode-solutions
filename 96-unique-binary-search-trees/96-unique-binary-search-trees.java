class Solution {
    // public int memo(int n,int[] dp){
    //     if(n == 0 || n == 1)return 1;
    //     if(dp[n] != 0)return dp[n];
    //     int ans = 0;
    //     for(int i = 0; i<n; ++i){
    //         ans = ans + memo(i, dp) *  memo(n-1 -i, dp);
    //     }
    //     return dp[n] = ans;
    // }
    public int numTrees(int n) {
        // return memo(n, dp);
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i<=n; ++i){
            for(int j = 0; j<i; ++j){
                dp[i] += dp[j] * dp[i-j-1]; 
            }
        }
        return dp[n];
    }
}