class Solution {
    public int memo(int i, int j, int m, int n, int[][] dp){
        if(i > m || j > n)return 0;
        if(i == m && j == n)return 1;
        if(dp[i][j] != -1)return dp[i][j];
        int ans = 0; 
        ans += memo(i+1, j, m, n, dp);
        ans += memo(i, j+1, m, n, dp);
        
        return dp[i][j] = ans;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                dp[i][j] = -1;
            }
        }
        return memo(0, 0, m-1, n-1, dp);
    }
}