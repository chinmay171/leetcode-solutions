class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)return 0;
        
        HashMap<Long, Long>[] dp = new HashMap[nums.length];
        for(int i = 0; i<nums.length; ++i){
            dp[i] = new HashMap<>();
        }
        
        long count =  0;
        
        for(int i = 1; i<nums.length; ++i){
            for(int j = i-1; j>=0; --j){
                long diff = 1l + nums[i]- nums[j];
                
                long oldVal = dp[i].getOrDefault(diff, 0l);
                long newVal = oldVal + dp[j].getOrDefault(diff, 0l) + 1l;
                
                dp[i].put(diff, newVal);
                count+= dp[j].getOrDefault(diff, 0l);
            }
        }
        return (int)count;
    }
}