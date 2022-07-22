class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] left = new int[nums.length];
        for(int i = 0; i<nums.length; ++i){
            left[i] = 1;
            for(int j = 0; j<nums.length; ++j){
                if(nums[i] > nums[j]){
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        
        int[] right = new int[nums.length];
        for(int i = nums.length-1; i>=0; i--){
            right[i] = 1;
            for(int j = nums.length-1; j>i; j--){
                if(nums[i] > nums[j]){
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        
        int maxBitonic = 0;
        for(int i = 0; i<nums.length; ++i){
            int curr = left[i] + right[i] - 1;
            if(left[i] > 1 && right[i] > 1){
                maxBitonic = Math.max(maxBitonic, curr);
            }
        }
        return nums.length - maxBitonic;
    }
}