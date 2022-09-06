class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int currLIS = 1;
        int maxLIS = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > nums[i-1]){
                currLIS++;
            }else{
                currLIS = 1;
            }
            
            maxLIS = Math.max(currLIS, maxLIS);
        }
        
        return maxLIS;
    }
}