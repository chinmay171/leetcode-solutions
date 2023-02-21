class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] yes = new int[n];
        int[] no = new int[n];
        
        yes[0] = nums[0];
        for(int i = 1; i < n; ++i){
            
            yes[i] = Math.max(yes[i-1], no[i-1] + nums[i]);
            no[i] = yes[i-1];
        }
        
        return yes[n-1];
    }
}