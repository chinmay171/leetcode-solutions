class Solution {
    public int memo(int[] nums, int prevCall, int idx, int[][] dp){
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx][prevCall] != -1)return dp[idx][prevCall];
        int ans1 = 0;
        int ans2 = 0;
        if(prevCall == 0){
            ans1 = memo(nums, 1, idx+1,dp)+nums[idx];
        }else{
            ans1 = 0;
        }
        ans2 = memo(nums, 0, idx+1,dp);
        return dp[idx][prevCall] = Math.max(ans1, ans2);
    }
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        for(int i = 0; i<nums.length; ++i){
            for(int j = 0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        return memo(nums, 0, 0,dp);
    }
}