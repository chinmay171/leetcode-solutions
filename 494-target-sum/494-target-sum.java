class Solution {
    public int memo(int[] arr, int sum){
        int[] dp = new int[sum+1];
	   
	   int n = arr.length;
	   dp[0] = 1;
	   
	   for(int i = 1; i<= n; ++i){
	       int[] newdp = new int[sum+1];
	       for(int j = 0; j<= sum; ++j){
	           int no  = dp[j];
	           int yes = (j >= arr[i-1]) ? dp[j-arr[i-1]] : 0;
	           
	           newdp[j] = yes + no;
	       }
	       dp = newdp;
	   }
	   
	   return dp[sum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(target > sum)return 0;
        if((sum-target) % 2 == 1)return 0;
        return memo(nums, (sum-target)/2);
    }
}