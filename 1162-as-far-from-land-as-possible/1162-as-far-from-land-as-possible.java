class Pair{
    int r;
    int c; 
    int dist;
    
    public Pair(int r, int c, int dist){
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}

class Solution {
    
    int[][] dirc = {{+1, 0},{-1, 0},{0, +1},{0, -1}};
    
    public int maxDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        int maxDist = -1;
        
        while(q.size() > 0){
            Pair top = q.remove();
            
            maxDist = Math.max(maxDist, top.dist);
            
            for(int i = 0; i < 4; ++i){
                int nr = top.r + dirc[i][0];
                int nc = top.c + dirc[i][1];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m){
                    continue;
                }
                if(vis[nr][nc] == true || grid[nr][nc] == 1){
                    continue;
                }
                
                vis[nr][nc] = true;
                q.add(new Pair(nr, nc, top.dist + 1));
            }
        }
        if(maxDist == 0) return -1;
        return maxDist;
    }
}