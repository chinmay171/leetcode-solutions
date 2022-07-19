class Solution {
    public int memo(int[] nums, int idx, int x, int[][] dp){
        if(idx == nums.length)return 0;
     
        if(dp[idx][x+1] != -1)return dp[idx][x+1];
        int yes = (x == -1 ||nums[idx] > nums[x])
                    ? memo(nums, idx+1, idx, dp)+1 : 0;
        int no = memo(nums, idx+1, x, dp);
        
        return dp[idx][x+1] = Math.max(yes, no);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i = 0; i<=nums.length; ++i){
            for(int j =0; j<=nums.length;++j){
                dp[i][j] = -1;
            }
        }
        return memo(nums, 0, -1, dp);
    }
}