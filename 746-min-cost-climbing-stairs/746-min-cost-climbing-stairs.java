class Solution {
    public int climbStairs(int[] jump, int idx, int[] dp){
        if(idx >= jump.length){
            return 0;
        }
        if(dp[idx] != -1)return dp[idx];
        int oneStep = climbStairs(jump, idx+1, dp);
        int twoStep = climbStairs(jump, idx+2, dp);
        return dp[idx] = Math.min(oneStep, twoStep)+jump[idx];
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+2];
        Arrays.fill(dp, -1);
        climbStairs(cost, 0, dp);
        return Math.min(dp[0], dp[1]);
    }
}