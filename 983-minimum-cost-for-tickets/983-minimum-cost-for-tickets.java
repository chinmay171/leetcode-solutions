class Solution {
    public int memo(int idx, int[] days, int[] costs, int[] dp){
        if(idx == days.length)return 0;
        
        if(dp[idx] != 0)return dp[idx];
        
        int onePass = costs[0] + memo(newIdx(idx, days, 1), days, costs, dp);
        
        int sevenPass = costs[1] + memo(newIdx(idx, days, 7), days, costs, dp);

        int monthPass = costs[2] + memo(newIdx(idx, days, 30), days, costs, dp);
        
        return dp[idx] = Math.min(onePass, Math.min(sevenPass, monthPass));
    }
    
    public int newIdx(int currIdx, int[] days, int durationOfPass){
        int endDay = days[currIdx] + durationOfPass - 1;
        int nextDay = currIdx;
        
        while(nextDay < days.length && days[nextDay] <= endDay){
            nextDay++;
        }
        
        return nextDay;
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length+1];
        return memo(0, days, costs, dp);
    }
}