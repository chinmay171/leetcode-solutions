class Solution {
    public int maxProfit(int[] prices, int fee) {
//         int[][] dp = new int[prices.length][2];
//         dp[0][0] = 0 - prices[0]; // buying col
//         dp[0][1] = 0; // selling col
        
//         for(int i = 1; i < prices.length; ++i){
//             //making buying column
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
//             //making selling column
//             dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
//         }
        
//         return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
        
        int buy = -prices[0];
        int sell = 0;
        
        for(int i = 0; i < prices.length; ++i){
            int newbuy = Math.max(buy, sell - prices[i]);
            int newsell= Math.max(sell, buy + prices[i] - fee);
            
            buy = newbuy;
            sell = newsell;
        }
        
        return Math.max(buy, sell);
    }
}