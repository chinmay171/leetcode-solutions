class Solution {
    public void countSort(int[] arr, int exp) {
    // write code here
        int[] freq = new int[10];

       for(int i = 0;i < arr.length; ++i){
           freq[arr[i] / exp % 10]++;
       }

       for(int i = 1; i < freq.length; ++i){
           freq[i] = freq[i] + freq[i-1];
       }

       int[] ans = new int[arr.length];
       for(int i = arr.length-1; i >= 0; i--){
           int idx = freq[arr[i] / exp % 10]-1;
           ans[idx] = arr[i];
           freq[arr[i] / exp % 10]--;
       }

       for(int i = 0; i< ans.length; ++i){
           arr[i] = ans[i];
       }
    }
    public int maximumGap(int[] nums) {
        int size = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<size; ++i){
            max = Math.max(max, nums[i]);
        }
        int exp = 1;
        while(exp <= max){
            countSort(nums, exp);
            exp *= 10;
        }
        int ans = 0;
        for(int i = 0; i<size-1; ++i){
            ans = Math.max(ans,nums[i+1]-nums[i]);
            System.out.println(ans);
        }
        return ans;
    }
}