class Solution {
    public boolean dfs(int src, ArrayList<Integer>[] graph, int[] vis, int count){
        if(vis[src] != -1){
            if(vis[src]%2 == count%2){
                return true;
            }else{
                return false;
            }
        }
        
        vis[src] = count % 2;
        
        for(int nbr : graph[src]){
            if(dfs(nbr, graph, vis, count+1) == false){
                return  false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n; ++i) graph[i] = new ArrayList<>();
        
        for(int[] alike : dislikes){
            graph[alike[0]].add(alike[1]);
            graph[alike[1]].add(alike[0]);
        }
        
        int[] vis = new int[n+1];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < n; ++i){
            if(vis[i] == -1 && dfs(i, graph, vis, 0) == false){
                return false;
            }
        }
        return true;
    }
}