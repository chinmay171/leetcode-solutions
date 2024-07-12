class Solution {
    public int maxSubArray(int[] nums) {
        int answer = nums[0];
        int currMaximum = 0;

        for(int i = 0; i < nums.length; ++i){
            currMaximum += nums[i];
            answer = Math.max(currMaximum, answer);
            if(currMaximum < 0){
                currMaximum = 0;
            }
        }

        return answer;
    }
}