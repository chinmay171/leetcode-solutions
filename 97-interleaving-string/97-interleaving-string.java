class Solution {
    public boolean memo(int i, int j, int k, String s1, String s2, String s3, Boolean[][] dp){
        if(k == s3.length())return true;
        
        char c1 = (i < s1.length()) ? s1.charAt(i) : 'A';
        char c2 = (j < s2.length()) ? s2.charAt(j) : 'B';
        char c3 = s3.charAt(k);
        
        if(dp[i][j] != null)return dp[i][j];
        
        if(c1 == c2 && c2 == c3){
            return dp[i][j] = (memo(i+1, j, k+1, s1, s2, s3, dp) || memo(i, j+1, k+1, s1, s2, s3, dp));
        }else if(c1 == c3){
            return dp[i][j] = memo(i+1, j, k+1, s1, s2, s3, dp);
        }else if(c2 == c3){
            return dp[i][j] = memo(i, j+1, k+1, s1, s2, s3, dp);
        }
        return dp[i][j] = false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length()+s2.length())return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return memo(0, 0, 0, s1, s2, s3, dp);
    }
}