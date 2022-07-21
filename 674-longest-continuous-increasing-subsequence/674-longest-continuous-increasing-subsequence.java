class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int currLIS = 0;
        int maxLIS = 0;
        for(int i = 0; i<nums.length; i++){
            if(i > 0 && nums[i] > nums[i-1]){
                currLIS++;
            }else{
                currLIS = 1;
            }
            maxLIS = Math.max(currLIS, maxLIS);
        }
        return maxLIS;
    }
}