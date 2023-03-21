class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        
        
        for(int k = 0; k < nums.length; k++){
            long curr = 0;
            while(k < nums.length && nums[k] == 0){
                curr++;
                k++;
            }
            ans = ans + (curr*(curr+1)/2);
        }
        return ans;
    }
}