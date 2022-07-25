class Solution {
    // public int lcs(String first, String second, int i, int j,int[][] dp){
    //     if(i == first.length() || j == second.length()){
    //         return 0;
    //     }
    //     if(dp[i][j] != -1)return dp[i][j];
    //     int ans = 0;
    //     if(first.charAt(i) == second.charAt(j)){
    //         ans = lcs(first, second, i+1, j+1,dp) + 1;
    //     }else{
    //         ans = Math.max(lcs(first, second, i+1, j,dp),lcs(first, second, i, j+1,dp));
    //     }
    //     return dp[i][j] = ans;
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] dp = new int[text1.length()+1][text2.length()+1];
        // for(int i = 0; i<text1.length(); ++i){
        //     for(int j = 0; j<text2.length(); ++j){
        //         dp[i][j] = -1;
        //     }
        // }
        // return lcs(text1, text2, 0, 0,dp);
        // for(int i = text1.length()-1; i>=0; --i){
        //     for(int j = text2.length()-1; j>=0; --j){
        //         if(text1.charAt(i) == text2.charAt(j)){
        //             dp[i][j] = dp[i+1][j+1] + 1;
        //         }else{
        //             dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
        //         }
        //     }
        // }
        // return dp[0][0];
        
        int[] next = new int[text2.length()+1];
        for(int i = text1.length()-1; i>=0; --i){
            
            int[] curr = new int[text2.length()+1];
            
            for(int j = text2.length()-1; j>=0; --j){
                
                if(text1.charAt(i) == text2.charAt(j)){
                    curr[j] = next[j+1] + 1;
                }else{
                    curr[j] = Math.max(next[j],curr[j+1]);
                }
            }
            next = curr;
        }
        return next[0];
    }
}