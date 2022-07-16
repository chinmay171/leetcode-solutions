class Solution {
    public int memo(int[][] matrix, int row, int col,int[][] dp){
        if(col < 0 || col >= matrix[0].length)return Integer.MAX_VALUE;
        if(row == matrix.length-1)return matrix[row][col];
        if(dp[row][col] != -1)return dp[row][col];
        int dPlus1 = memo(matrix, row+1, col-1, dp);
        int down = memo(matrix, row+1, col, dp);
        int dMinus1 = memo(matrix, row+1, col+1, dp);
        
        return dp[row][col] = Math.min(down, Math.min(dPlus1, dMinus1)) + matrix[row][col];
    }
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length; 
        
        int[][] dp = new int[row+1][col+1];
        for(int i=0; i<row; ++i){
            for(int j = 0; j<col; ++j){
                dp[i][j] = -1;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<row; ++i){
            ans = Math.min(ans, memo(matrix, 0, i, dp));
        }
        return ans;
    }
}