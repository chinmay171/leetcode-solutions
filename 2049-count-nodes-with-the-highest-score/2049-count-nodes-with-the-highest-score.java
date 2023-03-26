class Solution {
    int count = 0;
    long max = -1;
    int n;
    
    public int dfs(int src, ArrayList<Integer>[] adj, boolean[] vis){
        if(vis[src] == true) return 0;
        vis[src] = true;
        
        int lPlusR = 0;
        long its = 1;
        for(Integer nbr : adj[src]){
            int curr = dfs(nbr, adj, vis);
            lPlusR += curr;
            if(curr != 0) its *= (long)curr;
        }
        
        int par = n - (lPlusR + 1);
        if(par != 0)
            its *= (long)par;
        if(its > max){
            count = 1;
            max = its;
        }else if(its == max) count++;
        
        return lPlusR + 1;
    }
    
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            if(parents[i] == -1) continue;
            adj[i].add(parents[i]);
            adj[parents[i]].add(i);
         }
        
        boolean[] vis = new boolean[n];
        dfs(0, adj, vis);
        return count;
    }
}