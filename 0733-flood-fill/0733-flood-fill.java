class Solution {
    int[][] dir = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
    public void dfs(int[][] grid, int r, int c, int toBeColored, int initial, boolean[][] vis){
        if(vis[r][c] == true) return;
        vis[r][c] = true;
        grid[r][c] = toBeColored;
        
        for(int i = 0; i < 4; ++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length)
                continue;
            if(initial != grid[nr][nc]) continue;
            dfs(grid, nr, nc, toBeColored, initial, vis);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, color, image[sr][sc], vis);
        return image;
    }
}