class Solution {
    
    public int memo(int r, int c, int maxR, int maxC, int[][] matrix,int[][] dp){
        if(c < 0 || c >= maxC)return Integer.MAX_VALUE;
        
        if(r == maxR-1)return matrix[r][c];
        
        if(dp[r][c] != -1)return dp[r][c];
        
        int downLeft = memo(r+1, c-1, maxR, maxC, matrix, dp);
        int down = memo(r+1, c, maxR, maxC, matrix, dp);
        int downRight = memo(r+1, c+1, maxR, maxC, matrix, dp);
        
        return dp[r][c] = Math.min(down, Math.min(downLeft, downRight)) + matrix[r][c];
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0; i<= n; ++i){
            for(int j = 0; j<= m; ++j){
                dp[i][j] = -1;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; ++i){
            ans = Math.min(ans, memo(0, i, n, m, matrix, dp));
        }
        
        return ans;
    }
}