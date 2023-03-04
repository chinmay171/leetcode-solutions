class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        
        int mink = -1;
        int maxk = -1;
        
        int startOfNewSubarrays = -1;
        
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] >= minK && nums[i] <= maxK){
                mink = (nums[i] == minK) ? i : mink;
                maxk = (nums[i] == maxK) ? i : maxk;
                ans += Math.max(0, Math.min(mink, maxk) - startOfNewSubarrays);
            }else{
                mink = maxk = -1;
                startOfNewSubarrays = i;
            }
        }
        
        return ans;
    }
}