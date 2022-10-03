class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; ++i){
            int sum = 0;
            for(int j = 0; j < nums.length; ++j){
                if(i == j) continue;
                if(nums[i] + nums[j] == target){
                    int[] ans = {i, j};
                    return ans;
                }
            }
        }
        
        int[] nul = {-1};
        return  nul;
    }
}