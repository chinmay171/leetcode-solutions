class Solution {

    Queue<Integer> q;
    public boolean bfs(int src, int[][] graph, int set, int[] vis){
        q.add(src);
        vis[src] = set;

        while(q.size() > 0){
            set++;
            for(int i = q.size(); i > 0; i--){
                int top = q.remove();
                for(int nbr : graph[top]){
                    if(vis[nbr] == 0) vis[nbr] = set;
                    else if(vis[nbr] % 2 == set % 2) continue;
                    else return false;
                    q.add(nbr);
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        q = new ArrayDeque<>();

        for(int i = 0; i < graph.length; ++i)
            if(vis[i] == 0 && bfs(i, graph, 1, vis) == false) return false;
        
        return true;
    }
}