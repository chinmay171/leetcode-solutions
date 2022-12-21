class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int right = 0; right < nums.length; ++right){
            sum = sum + nums[right];
            
            while(sum >= target){
                minLen = Math.min(minLen, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}