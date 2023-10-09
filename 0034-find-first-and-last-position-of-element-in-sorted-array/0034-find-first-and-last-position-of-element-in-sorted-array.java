class Solution {

    public int lastOcc(int[] nums, int target){
        int high = nums.length - 1;
        int low = 0;

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                ans = mid;
            }
            if(nums[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public int firstOcc(int[] nums, int target){
        int high = nums.length-1;
        int low = 0;

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) ans = mid;
            if(nums[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = firstOcc(nums, target);
        ans[1] = lastOcc(nums, target);
        return ans;
    }
}