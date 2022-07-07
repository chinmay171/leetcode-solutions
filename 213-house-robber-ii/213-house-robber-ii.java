class Solution {
    public int memo(int[] nums, int prevCall, int idx,int n, int[][] dp){
        if(idx == n+1){
            return 0;
        }
        if(dp[idx][prevCall] != -1)return dp[idx][prevCall];
        int ans1 = 0;
        int ans2 = 0;
        if(prevCall == 0){
            ans1 = memo(nums, 1, idx+1, n,dp)+nums[idx];
        }else{
            ans1 = 0;
        }
        ans2 = memo(nums, 0, idx+1, n,dp);
        return dp[idx][prevCall] = Math.max(ans1, ans2);
    }
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        int[][] dp1 = new int[nums.length+1][2];
        for(int i = 0; i<nums.length; ++i){
            for(int j = 0; j<2; j++){
                dp1[i][j] = -1;
            }
        }
        int res1 = memo(nums, 0, 0,nums.length-2, dp1);
        
        int[][] dp2 = new int[nums.length+1][2];
        for(int i = 0; i<nums.length; ++i){
            for(int j = 0; j<2; j++){
                dp2[i][j] = -1;
            }
        }
        int res2 = memo(nums, 0, 1,nums.length-1, dp2);
        
        return Math.max(res1, res2);
    }
}