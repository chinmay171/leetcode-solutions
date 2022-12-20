class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int max = -1;
        int currFlip = 0;
        
        while(right < nums.length){
            int currMax = 0;
            while(right < nums.length && (nums[right] == 1 || currFlip < k)){
                currMax = right - left + 1;
                if(nums[right] != 1) currFlip++;
                right++;
            }
            while(left < nums.length && nums[left] != 0){
                left++;
            }
            left++;
            currFlip--;
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}