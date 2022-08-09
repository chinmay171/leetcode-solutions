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
        adj[dest].add(dest);
    }
}
// class Solution {
    
//     public int dfs(int src, Graph g, boolean[] vis){
        
//         if(vis[src] == true)return 0;

//         vis[src] = true;
        
//         for(int nbr : g.adj[src]){
//             dfs(nbr, g, vis);
//         }
//         return 1;
//     }
    
//     public int makeConnected(int n, int[][] connections) {
        
//         if(connections.length < n-1)return -1;
        
//         Graph g = new Graph(n);
        
//         for(int[] connection : connections){
//             g.addEdge(connection[0], connection[1]);
//         }
        
//         boolean[] vis = new boolean[n];
//         int comps = 0;
        
//         for(int i = 0; i < n; ++i){
//             comps += dfs(i, g, vis);
//         }

//         return comps-1;
//     }
// }

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // To connect all nodes need at least n-1 edges
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) components += dfs(v, graph, visited);
        return components - 1; // Need (components-1) cables to connect components together
    }
    int dfs(int u, List<Integer>[] graph, boolean[] visited) {
        if (visited[u]) return 0;
        visited[u] = true;
        for (int v : graph[u]) dfs(v, graph, visited);
        return 1;
    }
}