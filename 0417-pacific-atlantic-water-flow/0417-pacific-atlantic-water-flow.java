class Solution {
    int[][] dir = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
    
    public void dfs(int r, int c, int[][] mat, boolean[][] water){
        if(water[r][c] == true) return;
        water[r][c] = true;
        
        for(int i = 0; i < 4; ++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr < 0 || nc < 0 || nr >= mat.length || nc >= mat[0].length)
                continue;
            
            if(mat[nr][nc] >= mat[r][c]) dfs(nr, nc, mat, water);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        for(int i = 0; i < m; ++i) dfs(0, i, heights, pacific);
        for(int i = 0; i < n; ++i) dfs(i, 0, heights, pacific);
        
        boolean[][] atlantic = new boolean[n][m];
        for(int i = 0; i < m; ++i) dfs(n-1, i, heights, atlantic);
        for(int i = 0; i < n; ++i) dfs(i, m-1, heights, atlantic);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    ans.add(curr);
                }
        return ans;
    }
}