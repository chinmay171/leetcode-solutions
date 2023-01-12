class Solution {
    private int[] ans;
    private HashSet<Integer> vis;
    private ArrayList<Integer>[] adj; 
    
    private int[] dfs(int node, String labels){
        vis.add(node);
        
        int[] count = new int[26];
        for(int a : adj[node]){
            if(!vis.contains(a)){
                int[] adjChild = dfs(a, labels);
                for(int i = 0; i < 26; ++i){
                    count[i] += adjChild[i];
                }
            }
        }
        
        char ch = labels.charAt(node); 
        count[ch - 'a']++;
        ans[node] = count[ch - 'a'];
        return count;
    }
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        adj = new ArrayList[n];
        
        for(int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        ans = new int[n];
        vis = new HashSet<>();
        
        dfs(0, labels);
        return ans;
    }
}