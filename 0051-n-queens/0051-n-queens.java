class Solution {
    List<List<String>> ans = new ArrayList<>();
    public void addOutput(boolean[][] chess){
        List<String> curr = new ArrayList<>();
        int n = chess.length;
        for(int i = 0; i < n; ++i){
            String temp = "";
            for(int j = 0; j < n; ++j){
                if(chess[i][j] == false){
                    temp = temp + ".";
                }else{
                    temp = temp + "Q";
                }
            }
            curr.add(temp);
        }
        ans.add(curr);
    }
    
    public boolean isAttacking(boolean[][] chess, int row, int col){
        
        // top row
        for(int r = row; r >= 0; r--){
            if(chess[r][col] == true) return true;
        }
        
        // top left 
        for(int r = row, c = col; r >= 0 && c >= 0; r--, c--){
            if(chess[r][c] == true) return true;
        }
        
        for(int r = row, c = col; r >= 0 && c < chess.length; r--, c++){
            if(chess[r][c] == true) return true;
        }
        return false;
    }
    
    public void helper(int n, int row, boolean[][] chess){
        if(row == n){
            addOutput(chess);
            return;
        }
        
        for(int i = 0; i < n; ++i){
            if(isAttacking(chess, row, i) == false){
                chess[row][i] = true;
                helper(n, row+1, chess);
                chess[row][i] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][] chess = new boolean[n][n];
        helper(n, 0, chess);
        return ans;
    }
}