class Solution {
    
    public static class Pair{
        int src;
        int dist;
        Pair(int src, int dist){
            this.src = src;
            this.dist = dist;
        }
    }
    
    public int bfs(ArrayList<Integer>[] adj){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        
        int[] vis = new int[adj.length + 1];
        Arrays.fill(vis, -1);
        
        while(q.size() > 0){
            Pair front = q.remove();
            
            if(vis[front.src] != -1)continue;
            vis[front.src] = front.dist;
            
            for(Integer nbr : adj[front.src]){
                q.add(new Pair(nbr, front.dist + 1));
            }
        }
        
        return vis[adj.length - 1];
    }
    
    public int snakesAndLadders(int[][] matrix) {
        ArrayList<Integer> board = new ArrayList<>();
        board.add(0);
        
        int level = 0, cell = 1;
        for(int i = matrix.length-1; i >= 0; --i){
            if(level % 2 == 0){
                for(int j = 0; j < matrix[0].length; ++j){
                    if(matrix[i][j] == -1){
                        board.add(cell);
                    }else{
                        board.add(matrix[i][j]);
                    }
                    cell++;
                }
            }else{
                for(int j = matrix[0].length-1; j >= 0; --j){
                    if(matrix[i][j] == -1){
                        board.add(cell);
                    }else{
                        board.add(matrix[i][j]);
                    }
                    cell++;
                }
            }
            level++;
        }
        
        int size = matrix.length * matrix[0].length;
        ArrayList<Integer>[] adj = new ArrayList[size+1];
        
        for(cell = 1; cell <= size; ++cell){
            adj[cell] = new ArrayList<>();
            for(int d = 1; d <= 6 && cell + d <= size; ++d){
                if(cell == board.get(cell + d)) continue;
                adj[cell].add(board.get(cell+d));
            }
        }
        
        return bfs(adj);
    }
}