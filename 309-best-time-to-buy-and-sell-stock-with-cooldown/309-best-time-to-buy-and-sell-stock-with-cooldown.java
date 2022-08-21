class Solution {
    public int maxProfit(int[] prices) {
//         if(prices.length == 1)return 0;
//         int[][] dp = new int[prices.length][2];
//         // dp[0][0] = -prices[0];
//         // dp[0][1] = 0;
//         // dp[1][0] = Math.max(-prices[0], -prices[1]);
//         // dp[1][1] = Math.max(0, -prices[0] + prices[1]); 
        
//         for(int i = 2; i < prices.length; ++i){
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1] - prices[i]);
//             dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
//         }
        
//         return dp[prices.length-1][1];
        
        
        if(prices.length <= 1)return 0;
        
        int buy0 = -prices[0];
        int sell0 = 0;
        int buy1 = Math.max(-prices[0], -prices[1]);
        int sell1 = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < prices.length; ++i){
            int newBuy = Math.max(buy1, sell0 - prices[i]);
            int newSell = Math.max(sell1, buy1 + prices[i]);
            
            buy0 = buy1;
            sell0 = sell1;
            buy1 = newBuy;
            sell1 = newSell;
        }
        
        return sell1;
    }
}