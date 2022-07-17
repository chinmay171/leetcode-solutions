class Solution {
    public int memo(int[][] grid, int row, int col, int[][] dp){
        
        if(col < 0 || col >= grid[0].length)return Integer.MAX_VALUE;
        if(row == grid.length-1)return grid[row][col];
        if(dp[row][col] != -1)return dp[row][col];
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j<grid[row].length; ++j){
            if(j != col){
                ans = Math.min(ans, memo(grid, row+1, j, dp));
            }
        }
        // int dMinus1 = memo(grid, row+1, col-1, dp);
        // int dPlus1 = memo(grid, row+1, col+1, dp);
        
        return dp[row][col] = ans + grid[row][col];
    }
    public int minFallingPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] dp = new int[row+1][col+1];
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; ++j){
                dp[i][j] = -1;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<row; ++i){
            ans = Math.min(ans, memo(grid, 0, i, dp));
        }
        return ans;
    }
}