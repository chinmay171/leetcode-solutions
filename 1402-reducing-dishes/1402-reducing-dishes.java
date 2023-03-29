class Solution {
    public int memo(int time, int idx, int[] arr, int[][] dp){
        if(idx == arr.length) return 0;
        if(dp[idx][time] != -1) return dp[idx][time];
        
        int yes = memo(time+1, idx+1, arr, dp) + arr[idx]*time;
        int no = memo(time, idx+1, arr, dp);
        
        return dp[idx][time] = Math.max(yes, no);
    }
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        
        return memo(1, 0, satisfaction, dp);
    }
}