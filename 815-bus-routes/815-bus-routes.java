public class Pair implements Comparable<Pair>{
    int stop;
    int color;
    int change;
    
    Pair(int stop, int color, int change){
        this.stop = stop;
        this.color = color;
        this.change = change;
    }
    
    public int compareTo(Pair other){
        return (this.change - other.change);
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = 0; 
        for(int[] route : routes){
            for(int stop : route){
                n = Math.max(n, stop);
            }
        }
        
        ArrayList<Pair>[] adj = new ArrayList[n+1];
        for(int i = 0; i <= n; ++i) adj[i] = new ArrayList<>();
        
        for(int i = 0; i < routes.length; ++i){
            for(int j = 0; j < routes[i].length; ++j){
                int src = routes[i][j];
                int dest = routes[i][(j+1) % routes[i].length];
                
                adj[src].add(new Pair(dest, i, 0));
                adj[dest].add(new Pair(src, i, 0));
            }
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(source, routes.length, 0));
        
        int[][] vis = new int[n+1][routes.length+1];
        for(int i = 0; i <= n; ++i){
            for(int j = 0; j <= routes.length; ++j){
                vis[i][j] = -1;
            }
        }
        
        while(q.size() > 0){
            Pair top = q.remove();
            
            if(top.stop == target) return top.change;
            
            if(vis[top.stop][top.color] != -1) continue;
            vis[top.stop][top.color] = top.change;
            
            for(Pair nbr : adj[top.stop]){
                if(top.color == nbr.color){
                    q.add(new Pair(nbr.stop, nbr.color, top.change));
                }else q.add(new Pair(nbr.stop, nbr.color, top.change + 1));
            }
        }
        
        return -1;
    }
}