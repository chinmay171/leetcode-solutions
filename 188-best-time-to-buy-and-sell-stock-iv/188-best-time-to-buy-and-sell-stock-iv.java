class Solution {
    public int maxProfit(int cap, int[] prices) {
        if(prices.length == 0 || cap == 0)return 0;
//         int[][] dp = new int[k+1][prices.length];
        
//         for(int t = 1; t<=k; ++t){
//             for(int i = 0; i<prices.length; ++i){
//                 dp[t][i] = (i-1 >= 0) ? dp[t][i-1] : 0;
                
//                 for(int j = i-1; j>=0; j--){
//                     dp[t][i] = Math.max(dp[t][i], prices[i]- prices[j] + dp[t-1][j]);
//                 }
//             }
//         }
//         return dp[k][prices.length-1];
        
        int[][][] dp = new int[prices.length+1][2][cap+1];
        
        for(int i = prices.length-1; i >= 0; --i){
            for(int buy = 0; buy <= 1; ++buy){
                for(int k = 1; k <= cap; ++k){
                    
                    if(buy == 0){
                        dp[i][buy][k] = Math.max( -prices[i] + dp[i+1][1][k], 0 + dp[i+1][0][k]);
                    }else{
                        dp[i][buy][k] = Math.max( prices[i] + dp[i+1][0][k-1], 0 + dp[i+1][1][k]);
                    }
                }
            }
        }
        
        return dp[0][0][cap];
    }
}