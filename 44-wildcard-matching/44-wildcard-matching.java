class Solution {
//     public boolean memo(int i,int j,String s,String p, Boolean[][] dp){
//         if(i == s.length() && j == p.length())return true;
        
//         if(i < s.length() && j == p.length())return false;
        
//         if(i == s.length() && j < p.length()){
//             for(int k = j; k<p.length(); ++k){
//                 if(p.charAt(k) != '*')
//                     return false;
//             }
//             return true;
//         }
        
//         if(dp[i][j] != null)return dp[i][j];
        
//         char c1= s.charAt(i);
//         char c2= s.charAt(j);
        
//         if(c1 == c2 || c2 == '?'){
//             return dp[i][j] = memo(i+1, j+1, s, p, dp);
//         }
//         if(c2 == '*'){
            
//             boolean no = memo(i, j+1, s, p, dp);
//             if(no == true)return dp[i][j] = true;
            
//             boolean yes = memo(i+1, j, s, p, dp);
//             return dp[i][j] = yes;
//         }
        
//         return dp[i][j] = false;
//     }
    public boolean memo(int i, int j, String s1, String s2, Boolean[][] dp) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (i < s1.length() && j == s2.length()) {
            // first string is not empty, second string is empty
            return false;
        }

        if (i == s1.length() && j < s2.length()) {
            // first string is empty, second string is still left
            for (int k = j; k < s2.length(); k++) {
                if (s2.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (dp[i][j] != null)
            return dp[i][j];

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if (ch1 == ch2 || ch2 == '?') {
            return dp[i][j] = memo(i + 1, j + 1, s1, s2, dp);
        }

        if (ch2 == '*') {
            boolean no = memo(i, j + 1, s1, s2, dp);
            if (no == true)
                return dp[i][j] = true;

            boolean yes = memo(i + 1, j, s1, s2, dp);
            return dp[i][j] = yes;
        }

        // unequal characters
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return memo(0, 0, s, p, dp);
    }
}