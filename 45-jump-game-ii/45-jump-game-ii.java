class Solution {
    public long memo(int n, int[] jumps, long[] dp){
        if(n == jumps.length-1){
            return 0;
        }
        if(dp[n] != -1)return dp[n];
        long min = Integer.MAX_VALUE;
        for(int i = 1; i<=jumps[n]; ++i){
            if(i+n < jumps.length){
                min = Math.min(min, memo(n+i, jumps, dp)+1l);
            }
        }
        // dp[n] = min;
        return dp[n] = min;
    }
    public int jump(int[] nums) {
        long[] dp = new long[nums.length+1];
        Arrays.fill(dp, -1);
        return (int)memo(0,nums,dp);
    }
}