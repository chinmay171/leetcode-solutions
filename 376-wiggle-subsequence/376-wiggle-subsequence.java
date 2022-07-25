class Solution {
    public int wiggleMaxLength(int[] nums) {
//         int[] inc = new int[nums.length];
//         Arrays.fill(inc, 1);
        
//         int[] dec = new int[nums.length];
//         Arrays.fill(dec, 1);
        
//         int maxLength = 0;
//         for(int i = 0; i<nums.length; ++i){
            
//             for(int j = 0; j<i; ++j){
//                 if(nums[i] > nums[j]){
//                     //we are increasing
//                     inc[i] = Math.max(inc[i], dec[j]+1);
//                 }else if(nums[i] < nums[j]){
//                     //we are decreasing
//                     dec[i] = Math.max(dec[i], inc[j]+1);
//                 }
//             }
//             maxLength = Math.max(maxLength, Math.max(inc[i], dec[i]));
//         }
//         return maxLength;
        
        int inc = 1;
        int dec = 1;
        for(int i = 1; i<nums.length; ++i){
            if(nums[i] > nums[i-1])inc = dec+1;
            else if(nums[i] < nums[i-1])dec = inc+1;
        }
        return Math.max(inc, dec);
    }
}