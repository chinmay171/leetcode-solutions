class Solution {
    public int memo(int i, int j, int[][] grid, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1) return dp[i][j] = grid[i][j];
        
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int d = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        if(i+1 < m) d = memo(i+1, j, grid, m, n, dp);
        if(j+1 < n) r = memo(i, j+1, grid, m, n, dp);
        
        return dp[i][j] = Math.min(d, r) + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; ++i) for(int j = 0; j < n; ++j) dp[i][j] = Integer.MAX_VALUE;
        return memo(0, 0, grid, m, n, dp);
    }
}