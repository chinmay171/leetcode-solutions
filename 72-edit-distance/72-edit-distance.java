class Solution {
    public int memo(int i,int j,String s1, String s2, int[][] dp){
        if(i == s1.length() && j == s2.length())return 0;
        if(i == s1.length())return s2.length()-j;
        if(j == s2.length())return s1.length()-i;
        
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        
        if(dp[i][j] != -1)return dp[i][j];
        
        if(c1 == c2){
            return dp[i][j] = memo(i+1, j+1, s1, s2, dp);
        }
        else{
            int insert = memo(i, j+1, s1, s2, dp)+1;
            int delete = memo(i+1, j, s1, s2, dp)+1;
            int replace = memo(i+1, j+1, s1, s2, dp)+1;
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i<dp.length; ++i){
            for(int j = 0; j<dp[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        return memo(0, 0, word1, word2, dp);
    }
}