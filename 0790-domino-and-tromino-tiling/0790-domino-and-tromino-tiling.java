class Solution {
    public int m = 1000000007;
    public int numTilings(int n) {
        if(n == 1)return 1;
        if(n == 2)return 2;
        // int[] dp = new int[n+1];
        int dp0 = 1;
        int dp1 = 1;
        int dp2 = 2;
        
        for(int i = 3; i<=n; ++i){
            int curr = ((2 * dp2)% m + dp0)% m;
            
            dp0 = dp1;
            dp1 = dp2;
            dp2 = curr;
        }
        return dp2;
    }
}