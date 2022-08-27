class Solution {
    int[][] dir = {{+1, 0},{-1, 0},{0, +1},{0, -1}};
    public void dfs(int r, int c, char[][] grid){
        if(grid[r][c] != 'O')return;
        grid[r][c] = '*';
        
        for(int i = 0; i < 4; ++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                continue;
            }
            
            dfs(nr, nc, grid);
        }
    }
    
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        //top row
        for(int i = 0; i < m; ++i){
            if(board[0][i] == 'O') dfs(0, i, board);
        }
        
        //right column
        for(int i = 0; i < n; ++i){
            if(board[i][m-1] == 'O') dfs(i, m-1, board);
        }
        
        //bottam row
        for(int i = 0; i < m; ++i){
            if(board[n-1][i] == 'O') dfs(n-1, i, board);
        }
        
        //left column
        for(int i = 0; i < n; ++i){
            if(board[i][0] == 'O') dfs(i, 0, board);
        }
        
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j){
                if(board[i][j] == '*') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        
        // return board;
    }
}