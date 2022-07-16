class Solution {
    // public int memo(int[][] grid, int i, int j, int n, int m,int[][] dp){
    //     if(i >= n || j >= m)return Integer.MAX_VALUE;
    //     if(i == n-1 && j == m-1)return grid[i][j];
    //     if(dp[i][j] != -1)return dp[i][j];
    //     int h = memo(grid, i, j+1, n, m, dp);
    //     int v = memo(grid, i+1, j, n, m, dp) ;
    //     return dp[i][j] = Math.min(h, v)+grid[i][j];
    // }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i<=n; ++i){
            for(int j = 0; j<=m; ++j){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
//         return memo(grid, 0, 0, n, m, dp);
        // int[][] dp = new int[grid.length+1][grid[0].length+1];
         for(int i = n-1; i>=0; --i){
             for(int j = m-1; j>=0; --j){
                 if(i == n-1 && j == m-1){
                     dp[i][j] = grid[i][j];
                     continue;
                 }
                 dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + grid[i][j];
             }
         }
        return dp[0][0];
    }
}