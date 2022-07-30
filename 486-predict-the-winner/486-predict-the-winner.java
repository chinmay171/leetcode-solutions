class Solution {
    public int memo(int[] nums, int i, int j, int[][] dp){
        if(i > j)return 0;
        if(i == j)return nums[i];
        
        if(dp[i][j] != -1)return dp[i][j];
        
        int c1 = memo(nums, i+2, j, dp);
        int c2 = memo(nums, i+1, j-1, dp);
        int c3 = memo(nums, i, j-2, dp);
        
        return dp[i][j] = Math.max(nums[i] + Math.min(c1, c2),
                        nums[j] + Math.min(c2, c3));
    }
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i<dp.length; ++i){
            for(int j = 0; j<dp[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        
        int aScore = memo(nums, 0, nums.length-1, dp);
        
        int total = 0;
        for(int i = 0; i<nums.length; ++i){
            total += nums[i];
        }
        int bScore = total - aScore;
        if(aScore >= bScore)return true;
        return false;
    }
}