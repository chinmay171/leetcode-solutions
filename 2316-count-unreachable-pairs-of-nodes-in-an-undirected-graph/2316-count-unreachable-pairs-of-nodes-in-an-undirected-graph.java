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
    
    public void dfs(int source, boolean[] vis, List<Integer> component){
        if(vis[source] == true)return;
        
        vis[source] = true;
        component.add(source);
        
        for(Integer nbr : adj[source]){
            dfs(nbr, vis, component);
        }
    }
}
class Solution {
    public long countPairs(int n, int[][] edges) {
//         Graph g = new Graph(n);
        
//         for(int[] edge : edges){
//             g.addEdge(edge[0], edge[1]);
//         }
        
//         boolean[] vis = new boolean[n];
//         long ans = 0;
//         for(int i = 0; i<n; ++i){
//             if(vis[i] == false){
//                 List<Integer> component = new ArrayList<>();
//                 g.dfs(i, vis, component);
//                 ans = ans + ((component.size()) * ((n - 1l) - component.size()));
//             }
//         }
//         return ans/2l;
        Graph g = new Graph(n);
        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] vis = new boolean[n];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                List<Integer> component = new ArrayList<>();
                g.dfs(i, vis, component);
                ans = ans + ((component.size()) * ((n * 1l) - component.size()));
            }
        }

        return ans / 2l;
    }
}