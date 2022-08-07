class Solution {
    public void printPaths(int src, int dest, List<Integer> path, List<List<Integer>> paths, int[][] graph, boolean[] vis){
        
        if(vis[src] = false)return;
        
        vis[src] = true;
        path.add(src);
        
        if(src == dest){
            paths.add(new ArrayList<>(path));
        }
        
        for(int nbr : graph[src]){
            printPaths(nbr, dest, path, paths, graph, vis);
        }
        
        vis[src] = false;
        path.remove(path.size() -1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        
        boolean[] vis = new boolean[graph.length];
        
        printPaths(0, graph.length - 1, path, paths, graph, vis);
        return paths;
    }
}