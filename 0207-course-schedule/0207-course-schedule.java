class Solution {

    public boolean dfs(int src, ArrayList[] adj, int[] vis){
        if(vis[src] == 1) return false;
        if(vis[src] == 2) return true;
        vis[src] = 1;

        for(Object nbr : adj[src]){
            if(dfs((int)nbr, adj, vis) == false) return false;
            vis[(int)nbr] = 2;
        }
        vis[src] = 2;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] adj = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<>();
        for(int[] pre : prerequisites) adj[pre[1]].add(pre[0]);

        int[] vis = new int[numCourses];
        for(int i = 0; i < numCourses; ++i){
            if(vis[i] == 2) continue;
            if(dfs(i, adj, vis) == false) return false;
        }
        return true;
    }
}