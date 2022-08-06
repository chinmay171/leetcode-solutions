class Solution {
//     public int memo(String s, int idx){
//         if(idx == s.length())return 1;
        
//         int yes = memo(s, idx+1);
//         int no  = memo(s, idx+1);
        
//         return (yes+no);
//     }
    public int m = 1000000007;
    public int distinctSubseqII(String s) {
        // return memo(s, 0)-1;
        int[] dp = new int[s.length()+1];
        
        dp[0] = 1%m;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 1; i<=s.length(); ++i){
            dp[i] = (2 * dp[i-1])%m;
            
            if(hm.containsKey(s.charAt(i-1))){
                dp[i] = (dp[i] - dp[(hm.get(s.charAt(i-1)))%m -1])%m;
            }
            
            if(dp[i]<0){
                dp[i] += m;
            }
            
            hm.put(s.charAt(i-1), i);
        }
        
        return (dp[s.length()]-1)%m;
    }
}