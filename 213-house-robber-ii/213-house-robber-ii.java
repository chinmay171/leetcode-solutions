class Solution {
    
    public static int memo(int idx, int lastCall, int n, int[] nums, int[][] dp){
        if(idx == n)return 0;
        
        if(dp[idx][lastCall] != -1)return dp[idx][lastCall];
        
        int  rob = 0;
        int noRob = 0;
        if(lastCall == 0){
            rob = memo(idx+1, 1, n, nums, dp) + nums[idx];
        }
        noRob = memo(idx+1, 0, n, nums, dp);
        
        return dp[idx][lastCall] = Math.max(rob, noRob);
        
    }
    
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        int[][] dp = new int[nums.length +1][2];
        for(int i = 0; i <= nums.length; ++i){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        int ans1 = memo(0, 0, nums.length-1, nums, dp);
        
        int[][] dp2 = new int[nums.length +1][2];
        for(int i = 0; i <= nums.length; ++i){
            dp2[i][0] = -1;
            dp2[i][1] = -1;
        }
        int ans2 = memo(1, 0, nums.length, nums, dp2);
        
        return Math.max(ans1, ans2);
    }
}