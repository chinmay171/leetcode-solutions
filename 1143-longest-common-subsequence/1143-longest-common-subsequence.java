class Solution {
    public int lcs(String first, String second, int i, int j,int[][] dp){
        if(i == first.length() || j == second.length()){
            return 0;
        }
        if(dp[i][j] != -1)return dp[i][j];
        int ans = 0;
        if(first.charAt(i) == second.charAt(j)){
            ans = lcs(first, second, i+1, j+1,dp) + 1;
        }else{
            ans = Math.max(lcs(first, second, i+1, j,dp),lcs(first, second, i, j+1,dp));
        }
        return dp[i][j] = ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i<text1.length(); ++i){
            for(int j = 0; j<text2.length(); ++j){
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text2, 0, 0,dp);
    }
}