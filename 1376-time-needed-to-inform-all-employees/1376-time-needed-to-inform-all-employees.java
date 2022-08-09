class Pair{
    int dest;
    int weight;
    
    Pair(int dest, int weight){
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph{
    ArrayList<Pair>[] adj;
    
    Graph(int n){
        adj = new ArrayList[n];
        for(int i = 0; i < n; ++i){
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest, int weight){
            adj[src].add(new Pair(dest, weight));
    }
}

class Solution {
    
    public int dfs(int src, int time, Graph g){
        int maxTime = time;
        for(Pair p : g.adj[src]){
            maxTime = Math.max(maxTime , dfs(p.dest, time + p.weight, g));
        }
        return maxTime;
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Graph g = new Graph(n);
        
        int time = 0;
        
        for(int i = 0; i < n; ++i){
            if(manager[i] == -1){
                time = informTime[i];
            }else{
                g.addEdge(manager[i], i, informTime[i]);
            }
        }
        
        return dfs(headID, time, g);
    }
}