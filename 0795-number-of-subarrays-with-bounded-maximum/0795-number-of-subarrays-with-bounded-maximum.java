class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int si = 0;
        int ei = 0;
        
        int n = nums.length;
        int prev = 0;
        int ans = 0;
        
        while(ei < n){
            if(nums[ei] >= left && nums[ei] <= right){
                prev = ei - si + 1;
                ans += prev;
            }else if(nums[ei] < left){
                ans += prev;
            }else{
                si = ei + 1;
                prev = 0;
            }
            ei++;
        }
        
        return ans;
    }
}