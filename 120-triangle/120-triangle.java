class Solution {
    public int memo(int r, int c, List<List<Integer>> triangle, int[][] dp){
        if(r == triangle.size()-1){
            return triangle.get(r).get(c);
        }
        
        if(dp[r][c] != -1)return dp[r][c];
        
        int left = memo(r+1, c, triangle, dp);
        int right = memo(r+1, c+1, triangle, dp);
        
        return dp[r][c] = Math.min(left, right) + triangle.get(r).get(c);
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        for(int i = 0; i < triangle.size(); ++i)
            for(int j = 0; j < triangle.size(); ++j)
                dp[i][j] = -1;
        
        return memo(0, 0, triangle, dp);
    }
}