class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        
        int left = 0, max = 1;
        for(int i = 0; i< nums.length; ++i){
            int right = left+1, count= 1;
            while(right < nums.length && nums[right] <= nums[right-1]+1){
                if(nums[right] == nums[right-1]+1){
                    count++;
                }
                right++;
            }
            left = right;
            max = Math.max(max, count);
        }
        return max;
    }
}