class Pair{
    int dest;
    int dist;
    
    Pair(int dest, int dist){
        this.dest = dest;
        this.dist = dist;
    }
}

class Graph{
    ArrayList<Pair> adj[];
    
    Graph(int n){
        adj = new ArrayList[n];
        for(int i = 0; i < n; ++i){
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest, int dist){
        adj[src].add(new Pair(dest, dist));
        adj[dest].add(new Pair(src, dist));
    }
}

class Solution {
    int result = Integer.MAX_VALUE;
    
    public void dfs(int src, HashSet<Integer> vis, Graph g){
        if(vis.contains(src) == true) return;
        
        vis.add(src);
        
        // System.out.println(g.adj[src].size());
        for(Pair n : g.adj[src]){
            // System.out.println(n.dest + " " + n.dist);
            result = Math.min(result, n.dist);
            dfs(n.dest, vis, g);
        }
    }
    
    public int minScore(int n, int[][] roads) {
        
        Graph g = new Graph(n+1);
        
        for(int[] road : roads){
            g.addEdge(road[0], road[1], road[2]);
        }
        
        HashSet<Integer> vis = new HashSet<>();
        dfs(1, vis, g);
        return result;
    }
}