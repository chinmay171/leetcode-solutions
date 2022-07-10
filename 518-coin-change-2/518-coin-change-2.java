class Solution {
    // public int memo(int amount, int lastCoin, int[] coins, int[][] dp){
    //     if(amount < 0)return 0;
    //     if(amount == 0) return 1;
    //     if(dp[amount][lastCoin] != -1)return dp[amount][lastCoin];
    //     int ans = 0;
    //     for(int i = lastCoin; i<coins.length; ++i){
    //         ans += memo(amount - coins[i], i, coins, dp);
    //     }
    //     return dp[amount][lastCoin] = ans;
    // }
    public int change(int amount, int[] coins) {
        // int[][] dp = new int[amount+1][coins.length+1];
        // for(int i =0; i<=amount; ++i){
        //     for(int j = 0; j<=coins.length; ++j){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memo(amount, 0, coins, dp);
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i<= amount; ++i){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}