class Solution {
    
public int memo(int amount, int[] coins, int[] dp){
        if(amount < 0)return 0;
        if(amount == 0)return 1;
        if(dp[amount] != -1)return dp[amount];
        int ans = 0;
        for(int i = 0;i < coins.length; ++i){
            ans += memo(amount - coins[i], coins, dp);
        }
        return dp[amount] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return memo(target, nums, dp);
    }
}