class Solution {
    
    private int res;
    
    private void dfs(int u, int[] edges, boolean[] visited, boolean[] inRecursion, int[] count) {
        
        if(u != -1) {
            
            visited[u] = inRecursion[u] = true;
            
            int v = edges[u];
            
            if(v != -1 && !visited[v]) {
                
                count[v] = count[u] + 1;
                
                dfs(v, edges, visited, inRecursion, count);
                
            }
            
            else if(v != -1 && inRecursion[v]) { //cycle h provided inRecursion wla true ho
                
                res = Math.max(res, count[u]-count[v]+ 1);
                
            }
            
            inRecursion[u] = false;
            
        }
        
    }
    
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        
        this.res = -1;
        
        boolean visited[] = new boolean[n];
        boolean inRecursion[] = new boolean[n];
        
        int count[] = new int[n];
        Arrays.fill(count, 1);
        
        for(int i=0; i<n; i++) {
            
            if(!visited[i]) {
                
                dfs(i, edges, visited, inRecursion, count);
            }
            
        }
        
        return res;
    }
}