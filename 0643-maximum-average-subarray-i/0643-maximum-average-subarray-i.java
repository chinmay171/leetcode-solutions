class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int right = 0; right < nums.length; ++right){
            if(right < k){
                sum += nums[right];
            }else{
                // System.out.println(sum);
                maxSum = Math.max(maxSum, sum);
                sum += nums[right];
                sum -= nums[right - k];
            }
        }
        // System.out.println(sum);
        maxSum = Math.max(maxSum, sum);
        // System.out.println("___" + maxSum);
        double ans = maxSum / 1.0 / k;
        return ans;
    }
}