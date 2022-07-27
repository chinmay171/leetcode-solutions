class Solution {
    String scs= "";
    public void backtrack(int i, int j,String s1,String s2,int[][] dp,String ans){
        if(i == s1.length() && j == s2.length()){
            scs = ans;
            return;
        }
        
        char ch1 = (i < s1.length()) ? s1.charAt(i) : 'A';
        char ch2 = (j < s2.length()) ? s2.charAt(j) : 'B';
        
        if(ch1 == ch2){
            backtrack(i+1, j+1, s1, s2, dp, ans+ch1);
        }
        else if(i+1 <= s1.length() && dp[i][j] == dp[i+1][j]){
            backtrack(i+1, j, s1, s2, dp, ans+ch1);
        }
        else{
            backtrack(i, j+1, s1, s2, dp, ans+ch2);
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = str1.length()-1; i>=0; --i){
            for(int j = str2.length()-1; j>=0; --j){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        backtrack(0, 0,str1, str2, dp, "");
        return scs;
    }
}