class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int winSize = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 1) winSize++;
        }
//         int count = 0;
//         for(int left = 0; left < n && nums[left] == 1; ++left){
//             count++;
//         }
//         for(int right = n-1; right >= 0 && nums[right] == 1; --right){
//             count++;
//         }
//         if(count == winSize) return 0;
        
        
        
        int left = 0;
        int curr1Count = 0;
        int max1Count = 0;
        for(int right = 0; right < 2*n; ++right){
            if(right < winSize){
                if(nums[right%n] == 1) curr1Count++;
                max1Count = Math.max(max1Count, curr1Count);
            }else{
                if(nums[right%n] == 1) curr1Count++;
                if(nums[left%n] == 1) curr1Count--;
                left++;
                max1Count = Math.max(max1Count, curr1Count);
            }
        }
        
        return winSize - max1Count;
    }
}