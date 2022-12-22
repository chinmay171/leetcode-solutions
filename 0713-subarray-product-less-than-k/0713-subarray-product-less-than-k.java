class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int prod = 1;
        int count = 0;
        for(int right = 0; right < nums.length; ++right){
            prod *= nums[right];
            while(left <= right && prod >= k){
                prod /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}