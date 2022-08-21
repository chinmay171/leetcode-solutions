class Pair{
    int row, col;
    
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    int[][] call = {{+1, 0},{-1, 0},{0, +1},{0, -1}};
    
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        
        int[][] res = new int[mat.length][mat[0].length];
        
        for(int i = 0; i < mat.length; ++i)
            for(int j = 0; j < mat[0].length; ++j)
                if(mat[i][j] == 0){
                    res[i][j] = 0;
                    q.add(new Pair(i, j));
                }else res[i][j] = -1;
        
        while(q.size() > 0){
            Pair front = q.remove();
            
            
            for(int i = 0; i < 4; ++i){
                int nRow = front.row + call[i][0];
                int nCol = front.col + call[i][1];
                
                if(nRow < 0 || nCol < 0 || nRow >= mat.length || nCol >= mat[0].length)
                    continue;
                
                if(mat[nRow][nCol] == 0) continue;
                if(res[nRow][nCol] != -1) continue;
                
                q.add(new Pair(nRow, nCol));
                res[nRow][nCol] = res[front.row][front.col] + 1;
            }
        }
        
        return res;
    }
}