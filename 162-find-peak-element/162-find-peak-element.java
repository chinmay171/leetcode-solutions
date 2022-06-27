class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            
            int lval = (mid-1 >= 0) ? nums[mid-1] : Integer.MIN_VALUE;
            int rval = (mid+1 < nums.length) ? nums[mid+1] : Integer.MIN_VALUE;
            if(nums[mid] > lval && nums[mid] > rval)return mid;
            else if(nums[mid] < rval)left = mid+1;
            else right = mid-1;
        }
        return 0;
    }
}