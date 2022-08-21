class Solution {
    public int maxProfit(int[] prices) {
        int buying = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > buying) profit += prices[i] - buying;
            buying = prices[i];
        }
        return profit;
    }
}