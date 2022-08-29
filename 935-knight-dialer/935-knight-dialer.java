class Solution {
    int m = 1000000007;
    public long memo(int r, int c, int n, int[][] keyBoard, long[][][] dp){
        
        if(r < 0 || c < 0 || r >= 4 || c >= 3){
            return 0;
        }
        
        if(keyBoard[r][c] == -1) return 0;
    
        if(n == 1)return 1;
        
        if(dp[r][c][n] > 0) return dp[r][c][n];
        
        dp[r][c][n] = memo(r-2, c+1, n-1, keyBoard, dp) %m
                     +memo(r-1, c+2, n-1, keyBoard, dp) %m
                     +memo(r+1, c+2, n-1, keyBoard, dp) %m
                     +memo(r+2, c+1, n-1, keyBoard, dp) %m
                     +memo(r-2, c-1, n-1, keyBoard, dp) %m
                     +memo(r-1, c-2, n-1, keyBoard, dp) %m
                     +memo(r+1, c-2, n-1, keyBoard, dp) %m
                     +memo(r+2, c-1, n-1, keyBoard, dp) %m;
        
        return dp[r][c][n];
    }
    public int knightDialer(int N) {
        int[][] keyBoard = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
	    
	    long[][][] dp = new long[4][3][N+1];
	    
	    long ans = 0;
	    for(int i = 0; i < 4; ++i){
	        for(int j = 0; j < 3; ++j){
	            ans = (ans + memo(i, j, N, keyBoard, dp)) % m;
	        }
	    }
        return (int)ans;
    }
}