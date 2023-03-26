class Solution {
    int operation = 0;
    
    public boolean dfs(int src, ArrayList<Integer>[] adj, List<Boolean> hasApple, boolean[] vis){
        if(vis[src] == true) return false;
        vis[src] = true;
        
        boolean isApple = (hasApple.get(src) == true) ? true : false;
        for(Integer nbr : adj[src]){
            boolean curr = dfs(nbr, adj, hasApple, vis);
            if(curr == true) isApple = true;
        }
        
        if(isApple == true){
            operation += 2;
            return true;
        }
        return false;
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        boolean[] vis = new boolean[n];
        dfs(0, adj, hasApple, vis);
        return (operation == 0) ? operation : operation - 2;
    }
}