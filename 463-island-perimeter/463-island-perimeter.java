class Solution {
    public int dfs(int r, int c, int[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
            grid[r][c] == 0)return 1;
        
        if(grid[r][c] == -1)return 0;
        
        grid[r][c] = -1;
        
        int up = dfs(r-1, c, grid);
        int down = dfs(r+1, c, grid);
        int left = dfs(r, c-1, grid);
        int right = dfs(r, c+1, grid);
        
        return (up + down + left + right);
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int maxArea = 0;
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j] == 1){
                    maxArea = dfs(i, j, grid);
                }
            }
        }
        
        return maxArea;
    }
}