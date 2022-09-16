class pos{
    int r;
    int c;
    int d;
    
    public pos(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Solution {
    
    int[][] dirc = {{-1, 0},{-1, +1},{0, +1},{+1, +1},{+1, 0},{+1, -1},{0, -1},{-1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // System.out.println(n + " , " + m);
        
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }
        
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(0, 0, 0));
        
        while(q.size() > 0){
            
            pos top = q.remove();
            
            int row = top.r;
            int col = top.c;
            int dist = top.d;
            
            if(grid[row][col] == 1){
                continue;
            }
            grid[row][col] = 1;
            
            if(row == n-1 && col == m-1){
                    return dist+1;
                }
            
            for(int x = 0; x < 8; ++x){
                int nRow = row + dirc[x][0];
                int nCol = col + dirc[x][1];
                
                // System.out.println(nRow + " + " + nCol + " -> " + dist);
                
                if(nRow == n-1 && nCol == m-1){
                    return dist+2;
                }
                
                if(nRow < 0 || nCol < 0 || nRow >= n || nCol >= m){
                    continue;
                }
                if(grid[nRow][nCol] == 1){
                    continue;
                }
                q.add(new pos(nRow, nCol, dist + 1));
            }
            
        }
        
        return -1;
    }
}