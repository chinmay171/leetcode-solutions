class Solution {
    int[][] dir = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
    
    public void dfs(int r, int c, char[][] grid, boolean[][] vis){
        if(vis[r][c] == true) return;
        vis[r][c] = true;
        
        
        for(int i = 0; i < 4; ++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                continue;
            }
            if(grid[nr][nc] == '1')
                dfs(nr, nc, grid, vis);
        }
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                // System.out.print(vis[i][j] + " ");
                if(vis[i][j] == false && grid[i][j] == '1'){
                    // System.out.println(i + " " + j);
                    dfs(i, j, grid, vis);
                    ans++;
                }
            }
            // System.out.println();
        }
        return ans;
    }
}