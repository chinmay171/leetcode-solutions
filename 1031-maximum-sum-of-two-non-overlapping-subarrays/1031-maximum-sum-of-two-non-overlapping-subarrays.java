class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int x, int y) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        
        int sum = 0;
        for(int i = 0; i < dp1.length; ++i){
            if(i < x){
                sum += nums[i];
                dp1[i] = sum;
            }else{
                sum = sum + nums[i] - nums[i-x];
                dp1[i] = Math.max(sum, dp1[i-1]);
            }
        }
        
        sum = 0;
        for(int i = nums.length-1; i >=  0; --i){
            if(nums.length - i <= y){
                sum += nums[i];
                dp2[i] = sum;
            }else{
                sum = sum + nums[i] - nums[i+y];
                dp2[i] = Math.max(dp2[i+1], sum);
            }
        }
        
        int ans = 0;
        for(int i = x-1; i < nums.length-y; ++i){
            ans = Math.max(ans, dp1[i] + dp2[i+1]);
        }
        
        dp1 = new int[nums.length];
        dp2 = new int[nums.length];
        
        sum = 0;
        for(int i = 0; i < dp1.length; ++i){
            if(i < y){
                sum += nums[i];
                dp1[i] = sum;
            }else{
                sum = sum + nums[i] - nums[i-y];
                dp1[i] = Math.max(sum, dp1[i-1]);
            }
        }
        
        sum = 0;
        for(int i = nums.length-1; i >=  0; --i){
            if(nums.length - i <= x){
                sum += nums[i];
                dp2[i] = sum;
            }else{
                sum = sum + nums[i] - nums[i+x];
                dp2[i] = Math.max(dp2[i+1], sum);
            }
        }
        
        for(int i = y-1; i < nums.length-x; ++i){
            ans = Math.max(ans, dp1[i] + dp2[i+1]);
        }
        
        return ans;
    }
}