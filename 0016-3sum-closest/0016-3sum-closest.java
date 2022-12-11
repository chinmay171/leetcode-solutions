class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            // if(i > 0 && nums[i-1] == nums[i]){
            //     i++;
            //     continue;
            // }
            
            int start = i+1;
            int end = nums.length - 1;
            int tempTarget = target - nums[i];
            int j = start;
            while(start < end){
                // if(start > j && nums[start - 1] == nums[start]) continue;
                int diff = Math.abs(tempTarget - (nums[start] + nums[end]));
                if(closest > diff){
                    closest = diff;
                    sum = nums[i] + nums[start] + nums[end];
                }
                int currSum = nums[start] + nums[end];
                if(currSum == tempTarget)
                    return (nums[i] + nums[start] + nums[end]);
                else if(currSum < tempTarget){
                    start++;
                }else{
                    end--;
                }
            }
        }
        
        return sum;
    }
}