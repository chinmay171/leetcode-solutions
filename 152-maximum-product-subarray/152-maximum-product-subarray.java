class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = 1;
        int minProd = 1;
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i<nums.length; ++i){
            int currMax = Math.max(nums[i], Math.max(nums[i]*maxProd, nums[i]*minProd));
            int currMin = Math.min(nums[i], Math.min(nums[i]*maxProd, nums[i]*minProd));
            
            maxProd = currMax;
            minProd = currMin;
            
            ans = Math.max(ans, currMax);
        }
        return ans;
    }
}