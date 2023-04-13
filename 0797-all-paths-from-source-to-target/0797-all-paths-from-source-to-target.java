class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public void dfs(int src, int dest, int[][] graph, List<Integer> curr){
        if(src == dest){
            curr.add(dest);
            ans.add(new ArrayList<>(curr));
            curr.remove(Integer.valueOf(dest));
            return;
        }
        
        curr.add(src);
        for(int nbr : graph[src]){
            dfs(nbr, dest, graph, curr);
        }
        curr.remove(Integer.valueOf(src));
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0, graph.length-1, graph, new ArrayList<Integer>());
        return ans;
    }
}