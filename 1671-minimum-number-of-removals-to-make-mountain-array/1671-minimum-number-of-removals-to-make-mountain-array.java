class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length; 
        
        int[] IncreasingFromLeft = new int[n];
        for(int i = 0; i < n; ++i){
            IncreasingFromLeft[i] = 1;
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j]){
                    IncreasingFromLeft[i] = Math.max(IncreasingFromLeft[i], IncreasingFromLeft[j] + 1);
                }
            }
        }
        
        int[] IncreasingFromRight = new int[n];
        for(int i = n - 1; i >= 0; --i){
            IncreasingFromRight[i] = 1;
            for(int j = i+1; j < n; ++j){
                if(nums[i] > nums[j]){
                    IncreasingFromRight[i] = Math.max(IncreasingFromRight[i], IncreasingFromRight[j] + 1);
                }
            }
        }
        
        int LengthOfMountainArray = 0;
        for(int i = 0; i < n; ++i){
            int currLengthOfMountainArray = IncreasingFromLeft[i] + IncreasingFromRight[i] - 1;
            if(IncreasingFromLeft[i] > 1 && IncreasingFromRight[i] > 1){
                LengthOfMountainArray = Math.max(currLengthOfMountainArray, LengthOfMountainArray);
            }
        }
        
        return n - LengthOfMountainArray;
    }
}