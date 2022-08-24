class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        
        for(int i = prices.length-1; i >= 0; --i){
            for(int buy = 0; buy <= 1; ++buy){
                for(int k = 1; k <= 2; ++k){
                    
                    if(buy == 0){
                        dp[i][buy][k] = Math.max( -prices[i] + dp[i+1][1][k], 0 + dp[i+1][0][k]);
                    }else{
                        dp[i][buy][k] = Math.max( prices[i] + dp[i+1][0][k-1], 0 + dp[i+1][1][k]);
                    }
                }
            }
        }
        
        return dp[0][0][2];
    }
}