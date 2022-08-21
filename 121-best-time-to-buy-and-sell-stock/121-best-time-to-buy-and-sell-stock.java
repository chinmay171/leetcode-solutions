class Solution {
    public int memo(int profit, int idx, int[] prices, int min){
        if(idx == prices.length)return profit;
        min = Math.min(min, prices[idx]);
        profit = Math.max(profit, prices[idx] - min);
        return memo(profit, idx+1, prices, min);
    }
    
    public int maxProfit(int[] prices) {
        return memo(0, 0, prices, prices[0]);
    }
}