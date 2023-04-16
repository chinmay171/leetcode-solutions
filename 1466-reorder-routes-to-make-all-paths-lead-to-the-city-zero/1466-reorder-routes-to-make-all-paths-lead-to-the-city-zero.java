class Graph{
    ArrayList<Integer> adj[];
    Graph(int n){
        adj = new ArrayList[n];
        for(int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();
    }
    public void addEdge(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(-src);
    }
}
class Solution {
    int ans = 0;
    public void dfs(int src, Graph g, boolean[] vis){
        vis[src] = true;
        for(int nbr : g.adj[src]){
            if(vis[Math.abs(nbr)] == true) continue;
            dfs(Math.abs(nbr), g, vis);
            if(nbr > 0) ans++;
        }
    }
    public int minReorder(int n, int[][] connections) {
        Graph g = new Graph(n+1);
        for(int[] connection : connections)
            g.addEdge(connection[0]+1, connection[1]+1);
        boolean[] vis = new boolean[n+1];
        dfs(1, g, vis);
        return ans;
    }
}