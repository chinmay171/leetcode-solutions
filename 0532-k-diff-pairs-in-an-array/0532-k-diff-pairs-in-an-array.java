class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = left+1;
        int count = 0;
        while(left < nums.length && right < nums.length){
            if(left > 0 && nums[left-1] == nums[left]){
                left++;
                continue;
            }
            
            if(left == right){
                right++;
                continue;
            }
            int diff = nums[right] - nums[left];
            if(diff == k){
                count++;
                left++;
            }else if(diff < k){
                right++;
            }else{
                left++;
            }
        }
        
        return count;
    }
}