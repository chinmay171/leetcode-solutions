class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        
        for(int g = 0; g < dp.length; ++g){
            
            for(int i=0, j=g; j < dp[0].length; i++, j++){
                
                if(g == 0 || g == 1) dp[i][j] = 0;
                else if(g == 2){
                    dp[i][j] = values[i]*values[i+1]*values[i+2];
                }
                else{
                    int min = Integer.MAX_VALUE;
                    
                    for(int k = i+1; k <= j-1; ++k){
                        int tri = values[i]*values[j]*values[k];
                        int left = dp[i][k];
                        int right = dp[k][j];
                        
                        int total = tri + left + right;
                        
                        min = Math.min(min, total);
                    }
                    dp[i][j] = min;
                }
            }
        }
        
        return dp[0][dp[0].length - 1];
    }
}