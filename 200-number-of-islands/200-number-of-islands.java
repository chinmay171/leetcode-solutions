class Solution {
    public void dfs(int i, int j, char[][] grid){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 ||
           grid[i][j] == '0' || grid[i][j] == 'N')return;
        
        grid[i][j] = 'N';
        
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
    public int numIslands(char[][] grid) {
        
        int islands = 0;
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                if( grid[i][j] == '1'){
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}