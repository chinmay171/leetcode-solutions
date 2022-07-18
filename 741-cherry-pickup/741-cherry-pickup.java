class Solution {
    //WRONG APPROACH--> NEED TO BE REVISED //EXCEPTIONAL QUESTION
//     public int memo2(int[][] grid, int r, int c, int[][] dp){
//         if(r == 0 && c == 0)
//             return grid[r][c];
        
//         if(dp[r][c] != -1)return dp[r][c];
        
//         if(grid[r][c] == 1){
//             grid[r][c] = 0;
//         }
        
//         int left = (c-1 >= 0 && grid[r][c] != -1)
//                     ? memo2(grid, r, c-1,dp) : 0;
//         int up =  (r-1 >= 0 && grid[r][c] != -1)
//                     ? memo2(grid, r-1, c,dp) : 0;
        
//         return dp[r][c] = Math.max(left, up) + grid[r][c];
//     }
//     public int memo1(int[][] grid, int r, int c, int[][] dp){
//         if(r == grid.length-1 && c == grid[0].length-1)
//             return grid[r][c];
        
//         if(dp[r][c] != -1)return dp[r][c];
        
//         if(grid[r][c] == 1){
//             grid[r][c] = 0;
//         }
        
//         int right = (c+1 < grid[0].length && grid[r][c] != -1)
//                     ? memo1(grid, r, c+1,dp) : 0;
//         int down =  (r+1 < grid.length && grid[r][c] != -1)
//                     ? memo1(grid, r+1, c,dp) : 0;
        
//         return dp[r][c] = Math.max(right, down) + grid[r][c];
//     }
    
    public int memo(int[][] grid, int r1, int c1, int r2, int c2, int[][][] dp){
        //int c2 = r1+c1-r2;//remember ki c2 ko pass na bhi krre to bhi kaam chaljayega

        if(r1 >= grid.length || c1 >= grid[0].length || grid[r1][c1] == -1 ||
           r2 >= grid.length || c2 >= grid[0].length || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        
        if(r1 == grid.length-1 && c1 == grid[0].length-1)
            return grid[r1][c1];
        
        int ans = grid[r1][c1] + grid[r2][c2];
        if(r1 == r2 && c1 == c2) ans -= grid[r1][c1];
        
        if(dp[r1][c1][r2] != -1)return dp[r1][c1][r2];
        
        // int RR = (c1+1 < grid[0].length && c2+1 < grid[0].length && grid[r1][c1] != -1)
        //             ? memo(grid, r1, c1+1, r2, c2+1,dp) : Integer.MIN_VALUE;
        // int RD =  (c1+1 < grid[0].length && r2+1 < grid.length && grid[r1][c1] != -1)
        //             ? memo(grid, r1, c1+1, r2+1, c2,dp) : Integer.MIN_VALUE;
        // int DR = (r1+1 < grid.length && c2+1 < grid[0].length && grid[r2][c2] != -1)
        //             ? memo(grid, r1+1, c1, r2, c2+1,dp) : Integer.MIN_VALUE;
        // int DD =  (r1+1 < grid.length && r2+1 < grid.length && grid[r2][c2] != -1)
        //             ? memo(grid, r1+1, c1, r2+1, c2,dp) : Integer.MIN_VALUE;
        int RR = memo(grid, r1, c1+1, r2, c2+1, dp);
        int RD = memo(grid, r1, c1+1, r2+1, c2, dp);
        int DR = memo(grid, r1+1, c1, r2, c2+1, dp);
        int DD = memo(grid, r1+1, c1, r2+1, c2, dp);
        
        return dp[r1][c1][r2] = Math.max(Math.max(RR, RD), Math.max(DR, DD))+ans;
    }
    
    
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid.length];
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                for(int k = 0; k<grid.length; ++k){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int ans = memo(grid, 0, 0, 0, 0, dp);
        if(ans <= 0)return 0;
        return ans;
    }
}