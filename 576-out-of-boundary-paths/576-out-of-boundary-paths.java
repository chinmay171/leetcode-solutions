class Solution {
    int m = 1000000007;
    public int memo(int Row, int Col, int moves, int r, int c, int[][][] dp){
        if(r < 0 || c < 0 || r >= Row || c >= Col){
            return 1;
        }
        if(moves <= 0){
            return 0;
        }
        
        if(dp[r][c][moves] != -1) return dp[r][c][moves]%m;
        
        dp[r][c][moves] = ((memo(Row, Col, moves - 1, r-1, c, dp) %m + 
                            memo(Row, Col, moves - 1, r, c+1, dp) %m) %m +
                           (memo(Row, Col, moves - 1, r+1, c, dp) %m + 
                            memo(Row, Col, moves - 1, r, c-1, dp) %m) %m) %m;
        
        return dp[r][c][moves]%m;
        
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int[][][] dp = new int[m][n][maxMove+1];
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k <= maxMove; k++)
                    dp[i][j][k] = -1;
        
        return memo(m, n, maxMove, startRow, startColumn, dp);
    }
}