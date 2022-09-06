class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int maxLIS = 1;
        for(int i = 0; i < n; ++i){
            dp[i] = 1;
            
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }else if(nums[i] > nums[j] && dp[j] + 1 == dp[i]){
                    count[i] += count[j];
                }
            }
            
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        int no = 0;
        for(int i = 0; i < n; ++i){
            if(maxLIS == dp[i]) no += count[i];
        }
        return no;
    }
}