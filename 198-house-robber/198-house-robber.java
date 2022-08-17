class Solution {
    public int memo(int[] nums, int lastCall, int idx, int[][] dp){
        
        if(idx == nums.length)return 0;
        
        if(dp[idx][lastCall] != -1)return dp[idx][lastCall];
        
        int ans1 = 0;
        int ans2 = 0;
        if(lastCall == 0){
            ans1 = memo(nums, 1, idx+1, dp)+nums[idx];
        }
        ans2 = memo(nums, 0, idx+1, dp);
        
        return dp[idx][lastCall] = Math.max(ans1, ans2);
    }
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        
        for(int i = 0; i <= nums.length; ++i){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        
        return memo(nums, 0, 0, dp);
    }
}