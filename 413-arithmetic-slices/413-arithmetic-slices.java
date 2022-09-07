class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)return 0;
        
        int count = 0;
        int apLength = 2;
        int diff = nums[1] - nums[0];
        
        for(int i = 2; i < nums.length; ++i){
            if( (nums[i] - nums[i-1]) == diff){
                apLength++;
            }else{
                apLength = 2;
                diff = nums[i] - nums[i-1];
            }
            
            if(apLength >= 3){
                count += (apLength - 2);
            }
        }
        return count;
    }
}