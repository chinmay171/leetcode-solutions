class Solution {

    public int memo(int idx, int[] nums, int k, int[] dp){
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];

        int len = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int x = Math.min(nums.length, idx + k);
        for(int j = idx; j < x; ++j){
            len++;
            max = Math.max(max, nums[j]);
            int sum = (len * max) + memo(j + 1, nums, k, dp);
            maxSum = Math.max(maxSum, sum);
            
        }
        // System.out.println(maxSum);
        return dp[idx] = maxSum;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);

        return memo(0, arr, k, dp);
    }
}