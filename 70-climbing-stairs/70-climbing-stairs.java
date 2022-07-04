class Solution {
//     public int climbStairsHelper(int n, int[] dp){
//         if(n < 0)return 0;
//         if(n == 0)return 1;
        
//         if(dp[n] != -1)return dp[n];
//         int ans = 0;
//         if(n-1 >= 0){
//             ans += climbStairsHelper(n-1, dp);
//         }
//         if(n-2 >= 0){
//             ans +=  climbStairsHelper(n-2, dp);
//         }
//         dp[n] = ans;
//         return ans;
//     }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return climbStairsHelper(n, dp);\
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n; ++i){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}