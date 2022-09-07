class Solution {
    public int longestArithSeqLength(int[] nums) {
        int longest = 0;
        int diff = 0;
        int len = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        
        for(int i = 0; i < nums.length; ++i){
            dp[i] = new HashMap<>();
        }
        
        for(int i = 1; i < nums.length; ++i){
            for(int j = 0; j < i; ++j){
                
                diff = nums[i] - nums[j];
                len = dp[j].getOrDefault(diff, 1);
                
                dp[i].put(diff, len + 1);
                longest = Math.max(longest, len + 1);
            }
        }
        
        return longest;
    }
}