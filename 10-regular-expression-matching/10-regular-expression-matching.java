class Solution {
//     public boolean memo(int i,int j,String s,String p,Boolean[][] dp){
//         if (i == s.length() && j == p.length()) {
//             return true;
//         }

//         if (i < s.length() && j == p.length()) {
//             // first string is not empty, second string is empty
//             return false;
//         }

//         if (i == s.length() && j < p.length()) {
//             // first string is empty, second string is still left
//             for (int k = j; k < p.length(); k++) {
//                 if (p.charAt(k) != '*')
//                     return false;
//             }
//             return true;
//         }
         
//         if(dp[i][j] != null)return dp[i][j];
        
//         if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
//             return dp[i][j] = memo(i+1,j+1,s,p,dp);
//         }
//         if(p.charAt(j+1) == '*'){
//             boolean no = memo(i,j+2,s,p,dp);
//             if(no == true)return dp[i][j] = true;
            
//         }
//         return dp[i][j] = false;
//     }
    public boolean isMatch(String s, String p) {
        // Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        // return memo(0, 0, s, p, dp);
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        // fill inital row
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                //if character matches or . pick diagonal
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // if char is * then we check for no occurence by moving 2 step back in same row
                    if(p.charAt(j-1)=='*'){
                        // we check for no occurence by moving 2 step back in same row
                        // if its value is true we keep it
                        dp[i][j] = dp[i][j-2]; 
                        // if previous value of pattern matches or it .
                        // then pick from top
                        if(p.charAt(j-2)=='.'||s.charAt(i-1)==p.charAt(j-2)){
                            dp[i][j] = dp[i-1][j] || dp[i][j];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}