class Solution {
    // CODES for vowel
    //0 -> a
    //1 -> e
    //2 -> i
    //3 -> o
    //4 -> u
    
//     public int m = 1000000007;
//     public int memo(int n, int prevCode, int[][] dp){
//         if(n == 0)return 1;
        
//         int forA = 0;
//         int forE = 0;
//         int forI = 0;
//         int forO = 0;
//         int forU = 0;
        
//         int newN = (n-1)%m;
        
//         if(dp[n][prevCode] != -1)return dp[n][prevCode];
        
//         if(prevCode == 0){
//             forA += memo(newN, 1, dp)%m;
//             forE += memo(newN, 2, dp)%m;
//             forI += memo(newN, 3, dp)%m;
//             forO += memo(newN, 4, dp)%m;
//             forU += memo(newN, 5, dp)%m;
//         }
//         if(prevCode == 1){
//             forE += memo(newN, 2, dp)%m;
//         }
//         if(prevCode == 2){
//             forA += memo(newN, 1, dp)%m;
//             forI += memo(newN, 3, dp)%m;
//         }
//         if(prevCode == 3){
//             forA += memo(newN, 1, dp)%m;
//             forE += memo(newN, 2, dp)%m;
//             forO += memo(newN, 4, dp)%m;
//             forU += memo(newN, 5, dp)%m;
//         }
//         if(prevCode == 4){
//             forI += memo(newN, 3, dp)%m;
//             forU += memo(newN, 5, dp)%m;
//         }
//         if(prevCode == 5){
//             forU += memo(newN, 1, dp)%m;
//         }
        
//         return dp[n][prevCode] = (forA + forE + forI + forO + forU)%m;
//     }
    public int countVowelPermutation(int n) {
        // int[][] dp = new int[n+1][6];
        // for(int i = 0; i<=n; ++i){
        //     for(int j = 0; j<6; ++j){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memo(n, 0, dp);
        int[][] dp = new int[n+1][5];
        int mod = (int)1e9 + 7;
        int a = 0, e = 1, i = 2, o = 3, u = 4;
        Arrays.fill(dp[1], 1);
        
        for (int j = 2; j <= n; j++) {
            dp[j][a] += (((dp[j-1][e] + dp[j-1][i]) % mod) + dp[j-1][u]) % mod;
            dp[j][e] += (dp[j-1][a] + dp[j-1][i]) % mod;            
            dp[j][i] += (dp[j-1][e] + dp[j-1][o]) % mod;
            dp[j][o] += dp[j-1][i] % mod;
            dp[j][u] += (dp[j-1][i] + dp[j-1][o]) % mod;
        }                
        
        int res = 0;
        for (int j = 0; j < 5; j++) {
            res += dp[n][j];
            res %= mod;
        }
        
        return res;
    }
}