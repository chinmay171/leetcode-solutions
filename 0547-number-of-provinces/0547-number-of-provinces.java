class Graph{
    ArrayList<Integer>[] adj;
    
    Graph(int n){
        adj = new ArrayList[n];
        for(int i = 0; i < n; ++i){
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int a, int b){
        adj[a].add(b);
    }
}
class Solution {
    public void dfs(int src, Graph g, boolean[] visited){
        if(visited[src] == true) return;
        visited[src] = true;
        
        for(Integer nbr : g.adj[src]){
            dfs(nbr, g, visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Graph g = new Graph(n);
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(isConnected[i][j] == 1){
                    g.addEdge(i, j);
                }
            }
        }
        
        int comp = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; ++i){
            if(vis[i] == false){
                dfs(i, g, vis);
                comp++;
            }
        }
        
        return comp;
    }
}