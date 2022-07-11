class Solution {
    public int memo(int idx, int[] prices, int profit, int max){
        if(idx < 0)return profit;
        max = Math.max(max, prices[idx]);
        profit = Math.max(profit, max-prices[idx]);
        return memo(idx-1, prices, profit, max);
        
    }
    public int maxProfit(int[] prices) {
        return memo(prices.length-1, prices, 0, prices[prices.length-1]);
    }
}