class Solution {
    public int[] bfs(int n, ArrayList<Integer>[] adj){
        int[] incoming = new int[n];
        for(int src = 0; src < n; ++src){
            for(Integer nbr : adj[src]){
                incoming[nbr]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; ++i){
            if(incoming[i] == 0){
                q.add(i);
            }
        }
        
        int[] visited = new int[n];
        int idx = 0; 
        int vis = 0;
        while(q.size() > 0){
            int front = q.remove();
            visited[idx++] = front;
            vis++;
            
            for(Integer nbr : adj[front]){
                incoming[nbr]--;
                if(incoming[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        
        if(vis == n)return visited;
        return new int[0];
    }
    
    public int[] findOrder(int n, int[][] prerequisites) {
        
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++)adj[i] = new ArrayList<>();
        
        for(int[] edge : prerequisites) adj[edge[1]].add(edge[0]);
        
        return bfs(n, adj);
        
    }
}