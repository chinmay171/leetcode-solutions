class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)return 0;
        int ans = 0;
        int currAns = 2;
        int diff = nums[1]-nums[0];
        for(int i = 2; i<nums.length; ++i){
            int currDiff = nums[i]-nums[i-1];
            
            if(currDiff == diff){
                currAns++;
            }else{
                currAns = 2;
                diff = currDiff;
            }
            
            if(currAns >= 3){
                ans = ans + (currAns-2);
            }
        }
        return ans;
    }
}