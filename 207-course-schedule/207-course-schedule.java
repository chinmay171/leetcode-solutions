class Solution {
    
    public boolean dfs(int src, ArrayList<Integer>[] adj, int[] vis){
        if(vis[src] == 0)return true;
        if(vis[src] == 1)return false;
        
        vis[src] = 0;
        
        for(Integer nbr : adj[src]){
            if(dfs(nbr, adj, vis) == true){
                return true;
            }
        }
        
        vis[src] = 1;    
        return false;
        
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<>();
        for(int[] edge : prerequisites) adj[edge[0]].add(edge[1]);
        
        int[] vis = new int[numCourses];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < numCourses; ++i){
            if(vis[i] == -1 && dfs(i , adj, vis) == true){
                return false;
            }
        }
        return true;
    }
}