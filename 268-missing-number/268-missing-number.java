class Solution {
    
    public int missingNumber(int[] nums) {
        // int sum = 0;
        // for(int n : nums){
        //     sum += n;
        // }
        // for(int i = nums.length; i>0; --i){
        //     sum = sum - i;
        // }
        // return (0 - sum);
        
        int n = nums.length;
        
        for(int i = 0; i < nums.length; ++i){
            int val = nums[i] % (n+1);
            if(val < n) nums[val] += (n+1);
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] < n+1)return i;
        }
        return n;
    }
}