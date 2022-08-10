class Solution {
    int[][] dir = {{+1, 0},{-1, 0},{0, +1},{0, -1}};
    
    public void dfs(int r, int c, int[][] heights, boolean[][] vis){
        if(vis[r][c] == true)return;
        
        vis[r][c] = true;
        for(int i = 0; i < 4; ++i){
            int nr = r +dir[i][0];
            int nc = c +dir[i][1];
            
            if( nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length){
                continue;
            }
            if(heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, heights, vis);
            }
        }
        
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        
        // For Pacific Ocean
        for(int i = 0; i < m; ++i) dfs(0, i, heights, pacific);//Top Wall
        for(int i = 0; i < n; ++i) dfs(i, 0, heights, pacific);//Left Wall
        
        boolean[][] atlantic = new boolean[n][m];
        
        // For Atlantic Ocean
        for(int i = 0; i < m; ++i) dfs(n-1, i, heights, atlantic);//Bottom Wall
        for(int i = 0; i < n; ++i) dfs(i, m-1, heights, atlantic);//Right Wall
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    res.add(point);
                }
            }
        }
        return res;
    }
}