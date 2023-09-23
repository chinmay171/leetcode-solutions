class Solution {
    public static int m = 1000000007;
    
    // public long add(int a, int b){
    //     return ((a % m) + (b % m)) %m;
    // }
    
    public long kadane(int[] nums){
        long maxSum = 0, currSum = 0;
        for(int i = 0; i<nums.length; ++i){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
    public int kConcatenationMaxSum(int[] arr, int k) {
            if (k == 1) {
                return (int)kadane(arr);
            }

            int[] twice = new int[arr.length * 2];
            long total = 0;

            for (int i = 0; i < arr.length; i++) {
                total += arr[i];
                twice[i] = twice[i + arr.length] = arr[i];
            }

            if (total < 0)
                return (int)(kadane(twice) % m);
            return (int)((kadane(twice) + (k - 2) * total) % m);
    }
}