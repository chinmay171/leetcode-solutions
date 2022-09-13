class Solution {
    
    public int memo(int i, int j, String s1, String s2, int[][] dp){
        
        if(i == s1.length() && j == s2.length()){
            return 0;
        }
        if(i == s1.length() && j < s2.length()){
            int val = 0;
            for(int k = j; k < s2.length(); ++k){
                val += (int)s2.charAt(k);
            }
            return val;
        }
        if(i < s1.length() && j == s2.length()){
            int val = 0;
            for(int k = i; k < s1.length(); ++k){
                val += (int)s1.charAt(k);
            }
            return val;
        }
        
        if(dp[i][j] != -1)return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = memo(i+1, j+1, s1, s2, dp);
        }
        
        return dp[i][j] = Math.min(memo(i+1, j, s1, s2, dp) + (int)s1.charAt(i),
                                   memo(i, j+1, s1, s2, dp) + (int)s2.charAt(j));
    }
    
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); ++i){
            for(int j = 0; j < s2.length(); ++j){
                dp[i][j] = -1;
            }
        }
        
        return memo(0, 0, s1, s2, dp);
    }
}