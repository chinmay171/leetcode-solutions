class Solution {
    public int memo(int r, int c, int[][] grid, int[][] dp){
        if(r == grid.length || c == grid[0].length)return 0;
        if(grid[r][c] == 1)return 0;
        
        if(r == grid.length - 1 && c == grid[0].length -1)return 1;
        
        if(dp[r][c] != 0)return dp[r][c];
        
        int ans = 0;
        ans += memo(r+1, c, grid, dp);
        ans += memo(r, c+1, grid, dp);
        
        return dp[r][c] = ans;
    }
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        
        return memo(0, 0, grid, dp);
    }
}