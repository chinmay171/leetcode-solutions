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
        dp[n] = min;
        return min;
    }
    public int minTaps(int n, int[] ranges) {
        int[] jump = new int[n+1];
        for(int i = 0; i <= n; ++i) {
            int l = Math.max(0, i - ranges[i]);
            int r = Math.min(n, i + ranges[i]);
            jump[l] = Math.max(jump[l], r-l);
        }
        
        long[] dp = new long[jump.length+1];
        Arrays.fill(dp, -1);
        int ans = (int)memo(0,jump,dp);
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
    }
}