class Solution {
    public int maxProfit(int[] prices) {
//         int buying = prices[0];
//         int profit = 0;
        
//         for(int i = 0;i<prices.length; ++i){
//             if(buying < prices[i]){
//                 profit += prices[i]-buying;
//             }
//             buying = prices[i];
//         }
//         return profit;
        int[][] dp = new int[prices.length+1][2];
        dp[0][0] = 0 - prices[0];
        dp[0][1] = 0;
        for(int i = 1; i<prices.length; ++i){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length-1][1];
    }
}