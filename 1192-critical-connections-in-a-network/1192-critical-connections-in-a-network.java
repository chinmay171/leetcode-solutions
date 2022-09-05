class Solution {
    int[] disc;
    int[] lowest;
    int time;
    List<List<Integer>> bridges;
    
    public void dfs(int src, int parent, ArrayList<Integer>[] adj){
        
        disc[src] = lowest[src] = time;
        time++;
        
        for(Integer nbr : adj[src]){
            
            if(nbr == parent) continue;
            if(disc[nbr] >= 0){
                lowest[src] = Math.min(lowest[src], disc[nbr]);
            }else{
                dfs(nbr, src, adj);
                
                if(lowest[nbr] > disc[src]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(src);
                    bridge.add(nbr);
                    bridges.add(bridge);
                }
                lowest[src] = Math.min(lowest[src], lowest[nbr]);
            }
        }
        
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        disc = new int[n];
        lowest = new int[n];
        Arrays.fill(disc, -1);
        bridges = new ArrayList<>();
        
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; ++i)adj[i] = new ArrayList<>();
        
        for(List<Integer> edge : connections){
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }
        
        dfs(0, -1, adj);
        return bridges;
    }
}