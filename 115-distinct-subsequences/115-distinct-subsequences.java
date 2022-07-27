class Solution {
    public int memo(int i, int j,String s, String t,int[][] dp){
        if(j == t.length())return 1;
        if(i == s.length())return 0;
        
        if(dp[i][j] != -1)return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = (memo(i+1, j+1, s, t, dp) + memo(i+1, j, s, t, dp));
        }
        return dp[i][j] = memo(i+1, j, s, t, dp);
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0; i<s.length(); ++i){
            for(int j = 0; j<t.length(); ++j){
                dp[i][j] = -1;
            }
        }
        return memo(0, 0, s, t, dp);
    }
}