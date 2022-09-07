class Solution {
    public boolean dfs(int src, int[][] graph, int[] vis){
        if(vis[src] == 1)return true;
        if(vis[src] == -1)return false;
        
        vis[src] = 1;
        for(int nbr : graph[src]){
            if(dfs(nbr, graph, vis) == true){
                return true;
            }
        }
        
        vis[src] = -1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int[] vis = new int[graph.length];
        
        for(int i = 0; i < graph.length; ++i){
            if(vis[i] == 0){
                dfs(i, graph, vis);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<graph.length; i++) {
            if(vis[i] == -1)
                res.add(i);
        }
        
        return res;
    }
}