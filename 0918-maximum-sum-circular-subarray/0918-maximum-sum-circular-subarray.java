class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        
        int total = 0;
        for(int i = 0; i < nums.length; ++i){
            total += nums[i];
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        
        int minSum = Integer.MAX_VALUE;
        currSum = 0;
        
        for(int j = 0; j < nums.length; ++j){
            currSum = Math.min(currSum + nums[j], nums[j]);
            minSum = Math.min(minSum, currSum);
        }
        if(maxSum > 0){
            return Math.max(maxSum, total - minSum);
        }
        return maxSum;
    }
}