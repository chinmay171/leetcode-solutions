class Graph{
    ArrayList<Integer> adj[];
    
    Graph(int n){
        adj = new ArrayList[n];
        for(int i = 0; i < n; ++i){
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(-src);
    }
}

class Solution {
    public int edgesChanged = 0;
    
    public void dfs(int src, Graph g, boolean[] vis){
        if(vis[Math.abs(src)] == true) return;
        vis[src] = true;
        
        for(int n : g.adj[src]){
            if(vis[Math.abs(n)] == true) continue;
            if(n > 0){
                edgesChanged++;
                dfs(n, g, vis);
            }else{
                dfs(-n, g, vis);
            }
        }
    }
    
    public int minReorder(int n, int[][] connections) {
        Graph g = new Graph(n+1);
        
        for(int[] connection : connections){
            g.addEdge(connection[0]+1, connection[1]+1);
        }
        
        boolean[] visited = new boolean[n+1];
        
        dfs(1, g, visited);
        return edgesChanged;
    }
}