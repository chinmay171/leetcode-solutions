class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0)return 0;
        int[][] dp = new int[k+1][prices.length];
        
        for(int t = 1; t<=k; ++t){
            for(int i = 0; i<prices.length; ++i){
                dp[t][i] = (i-1 >= 0) ? dp[t][i-1] : 0;
                
                for(int j = i-1; j>=0; j--){
                    dp[t][i] = Math.max(dp[t][i], prices[i]- prices[j] + dp[t-1][j]);
                }
            }
        }
        return dp[k][prices.length-1];
    }
}