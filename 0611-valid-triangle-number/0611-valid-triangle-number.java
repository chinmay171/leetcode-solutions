class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length - 1; i > 1; --i){
            int targetSide = nums[i];
            
            int left = 0;
            int right = i - 1;
            while(left < right){
                int sideSum = nums[left] + nums[right];
                if(sideSum > targetSide){
                    count += right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        
        return count;
    }
}