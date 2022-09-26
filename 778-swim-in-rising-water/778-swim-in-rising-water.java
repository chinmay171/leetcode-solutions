class Solution {
    public class Pair implements Comparable<Pair>{
        int r;
        int c;
        int val;
        
        Pair(int r, int c, int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
        
        public int compareTo(Pair other){
            return (this.val - other.val);
        }
    }
    
    int[][] dirc = {{+1, 0},{-1, 0},{0, +1},{0, -1}};
    
    public int swimInWater(int[][] grid) {
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        
        while(pq.size() > 0){
            Pair top = pq.remove();
            
            if(vis[top.r][top.c] == true) continue;
            vis[top.r][top.c] = true;
            
            if(top.r == grid.length - 1 && top.c == grid[0].length - 1){
                return top.val;
            }
            
            for(int i = 0; i < 4; ++i){
                int nr = top.r + dirc[i][0];
                int nc = top.c + dirc[i][1];
                
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                    continue;
                }
                
                if(vis[nr][nc] == true) continue;
                
                pq.add(new Pair(nr, nc, Math.max(top.val, grid[nr][nc])));
            }
        }
        return -1;
    }
}