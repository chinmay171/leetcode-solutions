class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int maxLIS = 0;
        for(int i = 0; i<n; ++i){
            for(int j = 0; j<i; ++j){
                if(nums[i] > nums[j] && dp[i] <= dp[j]+1){
                    if(dp[i] < dp[j]+1){
                        count[i] = 0;
                    }
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    count[i] += count[j];
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        int countLIS = 0;
        for(int i = 0; i<n; ++i){
            if(dp[i] == maxLIS){
                countLIS += count[i];
            }
        }
        return countLIS;
    }
}