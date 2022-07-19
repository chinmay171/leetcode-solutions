class Solution {
    public int robo(int[][] grid, int r, int c1, int c2, int[][][] dp){
        if(c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length){
            return Integer.MIN_VALUE;
        }
        
        if(dp[r][c1][c2] != -1)return dp[r][c1][c2];
        
        int ans = grid[r][c1];
        if(c1 != c2){
            ans += grid[r][c2];
        }
        
        if(r == grid.length-1)return ans;
        // if(r2 == grid.length-1)return grid[r2][c2];
        int max = 0;
        
        int D1D1 = robo(grid, r + 1, c1 - 1, c2 - 1,dp);
        int D2D2 = robo(grid, r + 1, c1 + 1, c2 + 1,dp);
        int DD = robo(grid, r+1, c1, c2,dp);
        max = Math.max(max, Math.max(Math.max(D1D1, D2D2), DD));
        
        int D1D = robo(grid, r+1, c1 - 1, c2,dp);
        int D1D2 = robo(grid, r + 1, c1 - 1, c2 + 1,dp);
        int DD2 = Math.max(max, robo(grid, r+1, c1, c2 + 1,dp));
        max = Math.max(max, Math.max(Math.max(D1D, DD2), D1D2));
        
        int D2D = robo(grid, r+1, c1 + 1, c2,dp);
        int D2D1 = robo(grid, r + 1, c1 + 1, c2 - 1,dp);
        int DD1 = robo(grid, r+1, c1, c2 - 1,dp);
        max = Math.max(max, Math.max(Math.max(DD1, D2D), D2D1));
        
        return dp[r][c1][c2] = max+ans;
        
    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                for(int k = 0; k<grid[0].length; ++k){
                    dp[i][j][k] = -1;
                }
            }
        }
        return robo(grid, 0, 0, grid[0].length-1, dp);
    }
}