class Graph{
    ArrayList<Integer>[] adj;
    
    Graph(int n){
        adj = new ArrayList[n];
        for(int i = 0; i < n; ++i){
            adj[i] = new ArrayList<>();
        }
    }
    
    void addEdge(int curr, int nbr){
        adj[curr].add(nbr);
        adj[nbr].add(curr);
    }
}
class Solution {
    
    public boolean dfs(Graph g, int src, int dest, boolean[] vis){
        vis[src] = true;
        if(src == dest) return true;
        for(Integer nbr : g.adj[src]){
            if(vis[nbr] == true) continue;
            if(dfs(g, nbr, dest, vis) == true) return true;
        }
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        
        for(int[] edge : edges){
            g.addEdge(edge[0], edge[1]);
        }
        
        boolean[] vis = new boolean[n];
        return dfs(g, source, destination, vis);
    }
}