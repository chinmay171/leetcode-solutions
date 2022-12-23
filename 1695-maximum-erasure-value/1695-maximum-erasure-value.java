class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int maxSum = -1;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int right = 0; right < nums.length; ++right){
            sum += nums[right];
            
            if(set.contains(nums[right]) == true){
                while(nums[right] != nums[left]){
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            
            set.add(nums[right]);
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}