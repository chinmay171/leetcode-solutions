class Solution {
    int[][] dir = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
    
    public void dfs(int r, int c, char[][] board){
        if(board[r][c] != 'O') return;
        board[r][c] = '*';
        
        for(int i = 0; i < 4; ++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length)
                continue;
            
            dfs(nr, nc, board);
        }
    }
    
    public void solve(char[][] board) {
        // find all the 0s which should not be flipped through
        // DFS from all 4 borders and dont flip those cells and
        // flip all the others
        
        int n = board.length; 
        int m = board[0].length;
        
        for(int i = 0; i < m; ++i) dfs(0, i, board);
        for(int i = 0; i < n; ++i) dfs(i, 0, board);
        for(int i = 0; i < m; ++i) dfs(n-1, i, board);
        for(int i = 0; i < n; ++i) dfs(i, m-1, board);
        
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j){
                if(board[i][j] == '*') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
    }
}