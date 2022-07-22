class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] prev = new int[nums.length];
        Arrays.fill(prev, -1);
        int maxLIS = 0;
        int idx = 0;
        for(int i = 1; i<nums.length; ++i){
            for(int j = i-1; j>= 0; j--){
                if(nums[i] % nums[j] == 0 && dp[j]+1 > dp[i]){
                    prev[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > maxLIS){
                maxLIS = dp[i];
                idx = i;
            }
        }
        
        List<Integer> subset = new ArrayList<>();
        while(idx != -1){
            subset.add(nums[idx]);
            idx = prev[idx];
        }
        return subset;
    }
}