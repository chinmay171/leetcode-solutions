class Solution {
    
    public int memo(int i , int j, String word1, String word2, int[][] dp){
        if(i == word1.length() && j == word2.length()) return 0;
        if(i == word1.length()) return word2.length()-j;
        if(j == word2.length()) return word1.length()-i;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = memo(i+1, j+1, word1, word2, dp);
        }else{
            int insert = memo(i, j+1, word1, word2, dp) + 1;
            int delete = memo(i+1, j, word1, word2, dp) + 1;
            int replace = memo(i+1, j+1, word1, word2, dp) + 1;
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
    
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        
        return memo(0, 0, word1, word2, dp);
    }
}