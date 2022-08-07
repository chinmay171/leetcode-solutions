class Graph{
    ArrayList<Integer>[] adj;
    
    Graph(int n){
        adj = new ArrayList[n];
        for(int i = 0; i<n; ++i){
            adj[i] = new ArrayList<>();
        }
    }
    
    //unweighted graph
    public void addEdge(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
}
class Solution {
    public boolean dfs(int source, int destination, Graph g, boolean[] vis){
        if(source == destination)return true;
        if(vis[source] == true)return false;
        vis[source] = true;
        for(int nbr : g.adj[source]){
            if(dfs(nbr, destination, g, vis) == true)return true;
        }
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        
        for(int i = 0; i<edges.length; ++i){
            g.addEdge(edges[i][0], edges[i][1]);
        }
        
        boolean[] vis = new boolean[n];
        return dfs(source, destination, g, vis);
    }
}