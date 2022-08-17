class Pair{
    int row, col, dist;
    
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    int[][] call = {{+1, 0},{-1, 0},{0, +1},{0, -1}};
    
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        
        int min = 0;
        while(q.size() > 0){
            Pair front =  q.remove();
            
            if(grid[front.row][front.col] == 3)continue;
            grid[front.row][front.col] = 3;
            min = Math.max(min, front.dist);
            
            for(int i = 0; i < 4; ++i){
                int nr = front.row + call[i][0];
                int nc = front.col + call[i][1];
                
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                    continue;
                }
                
                if(grid[nr][nc] == 0 || grid[nr][nc] == 3){
                    continue;
                }
                
                q.add(new Pair(nr, nc, front.dist + 1));
            }
        }
        
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1)return -1;
            }
        }
        
        return min;
    }
}