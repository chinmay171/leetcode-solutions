class Solution {
    public int memo(int r, int c, int m, int n, int[][] dp){
        if(r == m || c == n) return 0;
        if(r == m-1 && c == n-1)return 1;
        
        if(dp[r][c] != 0)return dp[r][c];
        
        int ans = 0;
        ans += memo(r+1, c, m, n, dp);
        ans += memo(r, c+1, m, n, dp);
        
        return dp[r][c] = ans;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        return memo(0, 0, m, n, dp);
    }
}