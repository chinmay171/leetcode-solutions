class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1) return 0;
        
//         int left = 0;
//         int right = nums.length - 1;
        
//         while(left <= right){
//             if(nums[left] <= nums[left+1] && nums[right] >= nums[right-1]){
//                 left++;
//                 right--;
//             }else if(nums[left] > nums[left+1] && nums[right] < nums[right-1]){
//                 return right - left + 1;
//             }else if(nums[left] > nums[left+1] && nums[right] >= nums[right-1]){
//                 right--;
//             }else{
//                 left++;
//             }
//         }
        
//         return 0;
        
        int n = nums.length;
        int ptr1 = -1;
        int max = nums[0];
        for(int i = 1; i < n; ++i){
            if(nums[i] < max) ptr1 = i;
            else max = nums[i];
        }
        int ptr2 = 0;
        int min = nums[n-1];
        for(int i = n-2; i >= 0; --i){
            if(nums[i] > min) ptr2 = i;
            else min = nums[i];
        }
        return ptr1 - ptr2 + 1;
    }
}