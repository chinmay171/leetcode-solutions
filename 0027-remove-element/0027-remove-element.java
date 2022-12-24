class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        
        int idx = 0;
        for(int num : nums) if(num != val) nums[idx++] = num;
        return idx;
    }
}