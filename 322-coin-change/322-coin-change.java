class Solution {
    public int memo(int[] coins, int amount, int[] dp){
        if(amount == 0)return 0;
        if(dp[amount] != -1)return dp[amount];
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<coins.length; ++i){
            if(amount >= coins[i])
                min = Math.min(min, memo(coins, amount-coins[i], dp));
        }
        if(min < Integer.MAX_VALUE)min = min+1;
        return dp[amount] = min;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int ans = memo(coins, amount, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}