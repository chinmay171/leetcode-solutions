class Solution {
    
    public boolean isAttacking(boolean[][] chess, int row, int col) {
        // top
        for (int r = row; r >= 0; r--) {
            if (chess[r][col] == true)
                return true;
        }

        // top - left
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (chess[r][c] == true)
                return true;
        }

        // top - right
        for (int r = row, c = col; r >= 0 && c < chess.length; r--, c++) {
            if (chess[r][c] == true)
                return true;
        }

        return false;
    }
    
    public int recursion(int n, int row, boolean[][] chess){
        if(n == row) return 1;
        
        int ans = 0;
        for(int i = 0; i < n; ++i){
            if(isAttacking(chess, row, i) == false){
                chess[row][i] = true;
                ans += recursion(n, row+1, chess);
                chess[row][i] = false;
            }
        }
        return ans;
    }
    
    public int totalNQueens(int n) {
        return recursion(n, 0, new boolean[n][n]);
    }
}