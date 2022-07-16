class Solution {
    public int helper(List<List<Integer>> triangle, int i, int j, int[][] dp,int n){
        if(i == n-1)return triangle.get(i).get(j);
        if(j>=n)return Integer.MAX_VALUE;
        if(dp[i][j] != -1)return dp[i][j];
        int down = helper(triangle, i+1, j, dp,n);
        int dia = helper(triangle, i+1, j+1, dp,n);
        
        return dp[i][j] = Math.min(down, dia)+triangle.get(i).get(j);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i<n;++i){
            for(int j = 0; j<n;++j){
                dp[i][j] = -1;
            }
        }
        
        return helper(triangle, 0, 0, dp, n);
    }
}