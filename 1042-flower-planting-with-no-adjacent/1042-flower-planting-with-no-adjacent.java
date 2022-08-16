class Solution {
    int[] ans;
    List<List<Integer>> adj;
    
    public boolean canColor(int src, int toBeColored){
        for(int nbr : adj.get(src)){
            if(ans[nbr] == toBeColored)return false;
        }
        return true;
    }
    
    public boolean helper(int src, int n){
        if(src == n)return true;
        
        for(int i = 1; i <= 4; ++i){
            if(canColor(src, i) == true){
                ans[src] = i;
                if(helper(src+1, n) == true)return true;
                ans[src] = 0;
            }
        }
        
        return false;
        
    }
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        adj = new ArrayList<>();
        for(int i = 0; i < n; ++i) adj.add(new ArrayList<>());
        
        for(int i = 0; i < paths.length; ++i){
            adj.get(paths[i][0]-1).add(paths[i][1]-1);
            adj.get(paths[i][1]-1).add(paths[i][0]-1);
        }
        
        ans = new int[n];
        
        helper(0, n);
        
        return ans;
    }
}