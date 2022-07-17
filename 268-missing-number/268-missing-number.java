class Solution {
    
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        for(int i = nums.length; i>0; --i){
            sum = sum - i;
        }
        return (0 - sum);
    }
}