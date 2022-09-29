class Solution {
    
    public boolean isPallindrome(String str){
        int l = 0;
        int r = str.length() - 1;
        
        while(l <= r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    public int helper(String str, int i, int[] dp){
        
        if(i == str.length()){
            return 0;
        }
        
        if(dp[i] != -1) return dp[i];
        
        if(isPallindrome(str.substring(i)) == true) return dp[i] = 0;
        
        int ans = Integer.MAX_VALUE;
        for(int j = i; j < str.length(); ++j){
            String left = str.substring(i, j + 1);
            if(isPallindrome(left) == true){
                int cuts = helper(str, j+1, dp);
                ans = Math.min(ans, cuts + 1);
            }
        }
        return dp[i] = ans;
    }
    
    public int minCut(String s) {
        int[] dp = new int[s.length()+ 1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
}