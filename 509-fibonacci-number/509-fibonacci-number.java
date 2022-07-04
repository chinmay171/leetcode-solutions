class Solution {
    public int fib(int n, int[] dp){
        if(n<=1)return n;
        if(dp[n] != -1){
            return dp[n];
        }
        int prev1 = fib(n-1, dp);
        int prev2 = fib(n-2, dp);
        dp[n] = prev1 + prev2;
        return prev1+prev2;
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fib(n, dp);
    }
}