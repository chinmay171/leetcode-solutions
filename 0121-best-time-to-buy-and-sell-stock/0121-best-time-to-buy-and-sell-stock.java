class Solution {
//     public int memo(int profit, int idx, int[] prices, int min){
//         if(idx == prices.length)return profit;
//         min = Math.min(min, prices[idx]);
//         profit = Math.max(profit, prices[idx] - min);
//         return memo(profit, idx+1, prices, min);
//     }
    
    public int maxProfit(int[] prices) {
        // return memo(0, 0, prices, prices[0]);
        int selling = prices[prices.length - 1];
        int profit = 0;
        
        for(int i = prices.length - 1; i >= 0; --i){
            selling = Math.max(selling, prices[i]);
            int buying = prices[i];
            profit = Math.max(profit, selling - buying);
        }
        return profit;
    }
}