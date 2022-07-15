class Solution {
    public boolean memo(int[] arr, int sum){
        boolean[] dp = new boolean[sum+1];
	   
	   int n = arr.length;
	   dp[0] = true;
	   
	   for(int i = 1; i<= n; ++i){
	       boolean[] newdp = new boolean[sum+1];
	       for(int j = 0; j<= sum; ++j){
	           boolean no  = dp[j];
	           boolean yes = (j >= arr[i-1]) ? dp[j-arr[i-1]] : false;
	           
	           newdp[j] = (yes || no);
	       }
	       dp = newdp;
	   }
	   
	   return dp[sum];
    }
    
    public boolean canPartition(int[] nums) {
        // int[] dp = new int[nums.length+1];
        int sum = 0;
         for(int i = 0; i<nums.length;++i){
             sum += nums[i];
         }
        if(sum % 2 == 1)return false;
        return memo(nums, sum/2);
    }
}