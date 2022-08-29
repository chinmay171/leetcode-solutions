class Solution {
    public class Graph{
        ArrayList<Integer>[] adj;
        
        Graph(int n){
            adj = new ArrayList[n];
            for(int i = 0; i < n; ++i){
                adj[i] = new ArrayList<>();
            }
        }
        
        public void addEdge(int src, int dest){
            adj[src].add(dest);
            adj[dest].add(src);
        }
    }
    
    public void dfs(int src, Graph g, boolean[] vis){
        if(vis[src] == true)return;
        vis[src] = true;
        
        for(int nbr : g.adj[src]){
            dfs(nbr, g, vis);
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1)return -1;
        
        Graph g = new Graph(n);
        
        for(int[] c : connections){
            g.addEdge(c[0], c[1]);
        }
        
        int comp = 0;
        
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; ++i){
            if(vis[i] == false){
                dfs(i, g, vis);
                comp++;
            }
        }
        return comp - 1;
    }
}