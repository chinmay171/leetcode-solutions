class Solution {
    public int memo(int[] nums, int i, int j, int[][] dp){
        if(i > j)return 0;
        if(i == j)return nums[i];
        
        if(dp[i][j] != -1)return dp[i][j];
        
        int c1 = memo(nums, i+1, j, dp);
        int c2 = memo(nums, i, j-1, dp);
        
        return dp[i][j] = Math.max(nums[i] - c1, nums[j] - c2);
    }
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i<dp.length; ++i){
            for(int j = 0; j<dp[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        
        int diff = memo(nums, 0, nums.length-1, dp);
        
        if(diff >= 0) return true;
        return false;
    }
}