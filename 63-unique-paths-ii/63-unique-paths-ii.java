class Solution {
    public int memo(int sr, int sc, int[][] grid, int[][] dp){
        if(sr > grid.length-1 || sc > grid[0].length-1)return 0;
        if(sr == grid.length-1 && sc == grid[0].length-1)return 1;
        if(grid[sr][sc] == 1)return 0;
        if(dp[sr][sc] != -1)return dp[sr][sc];
        
        return dp[sr][sc] = (memo(sr+1, sc, grid, dp) + memo(sr, sc+1, grid, dp));
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)return 0;
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)return 0;
        
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i<obstacleGrid.length; ++i){
            for(int j = 0; j<obstacleGrid[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        return memo(0, 0, obstacleGrid, dp);
    }
}