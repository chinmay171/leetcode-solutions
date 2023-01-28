class Solution {
    
    public boolean isSafe(char[][] board, int row, int col, char ch){
        for(int c = 0; c < 9; c++){
            if(board[row][c] == ch) return false;
        }
        
        for(int r = 0; r < 9; r++){
            if(board[r][col] == ch) return false;
        }
        
        int tr = (row / 3) * 3;
        int tc = (col / 3) * 3;
        for(int r = 0; r < 3; ++r){
            for(int c = 0; c < 3; ++c){
               if(board[r + tr][c + tc] == ch) return false; 
            }
        }
        return true;
    }
    
    public boolean recursion(char[][] board, int row, int col){
        if(col == 9){
            row++;
            col = 0;
        }
        if(row == 9) return true;
        if(board[row][col] != '.')
            return recursion(board, row, col+1);
        
        for(char ch = '1'; ch <= '9'; ch++){
            if(isSafe(board, row, col, ch) == false) continue;
            
            board[row][col] = ch;
            if(recursion(board, row, col) == true)
                return true;
            board[row][col] = '.';
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        recursion(board, 0, 0);
    }
}