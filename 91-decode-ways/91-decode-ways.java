class Solution {
    public int memo(String s, int idx, int[] dp){
        if(idx == s.length()) return 1;
        if(dp[idx] != 0)return dp[idx];
        int take1char = 0;
        int take2char = 0;
        if(s.charAt(idx) != '0'){
            take1char = memo(s,idx+1, dp);
        }
        if(idx+1 < s.length() && s.charAt(idx) != '0'){
            int code = (s.charAt(idx)-'0')*10 + (s.charAt(idx+1)-'0');
            if(code >= 10 && code <= 26){
                take2char = memo(s, idx+2,dp);
            }
        }
        return dp[idx] = (take1char+take2char);
        
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        return memo(s, 0, dp);
    }
}