class Graph{
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
    
    public void dfs(int src, boolean[] vis){
        if(vis[src] == true)return;
        
        vis[src] = true;
        for(int nbr : adj[src]){
            dfs(nbr, vis);
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        Graph g = new Graph(n);
        
        for(int i = 0; i<n; ++i){
            for(int j = 0; j<m; ++j){
                if(i != j && isConnected[i][j] == 1){
                    g.addEdge(i, j);
                }
            }
        }
        
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; ++i){
            if(vis[i] == false){
                count++;
                g.dfs(i, vis);
            }
        }
        
        return count;
    }
}