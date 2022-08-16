class Solution {
    
    public boolean dfs(int src, int set, int[][]graph, int[] vis){
        if(vis[src] != -1){
            if(vis[src] != set)return false;
            return true;
        }
        
        vis[src] = set;
        
        for(int nbr : graph[src]){
            if(dfs(nbr, 1-set, graph, vis) == false){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < graph.length; ++i){
            if(vis[i] == -1 && dfs(i, 0, graph, vis) == false){
                return false;
            }
        }
        
        return true;
    }
}