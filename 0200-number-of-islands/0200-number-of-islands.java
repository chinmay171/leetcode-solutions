class Solution {

    int[][] dir = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

    public void dfs(int r, int c, char[][] grid, int[][] vis){
        vis[r][c] = 1;

        for(int i = 0; i < 4; ++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length){
                continue;
            }
            if(vis[nr][nc] == 0 && grid[nr][nc] == '1') dfs(nr, nc, grid, vis);
        }
    }

    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];

        int ans = 0;
        for(int i = 0; i < grid.length; ++i)
            for(int j = 0; j < grid[0].length; ++j)
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    dfs(i, j, grid, vis);
                    ans++;
                }

        return ans;
    }
}