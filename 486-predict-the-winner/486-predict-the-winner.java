class Solution {
    public int memo(int[] nums, int i, int j){
        if(i > j)return 0;
        if(i == j)return nums[i];
        
        int c1 = memo(nums, i+2, j);
        int c2 = memo(nums, i+1, j-1);
        int c3 = memo(nums, i, j-2);
        
        return Math.max(nums[i] + Math.min(c1, c2), nums[j] + Math.min(c2, c3));
    }
    public boolean PredictTheWinner(int[] nums) {
        int aScore = memo(nums, 0, nums.length-1);
        
        int total = 0;
        for(int i = 0; i<nums.length; ++i){
            total += nums[i];
        }
        int bScore = total - aScore;
        if(aScore >= bScore)return true;
        return false;
    }
}