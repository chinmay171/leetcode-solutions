class Solution {
    public long countSubarrays(int[] nums, long k) {
        long left = 0;
        long sum = 0;
        long prod = 1;
        long count = 0;
        
        for(long right = 0; right < nums.length; ++right){
            sum += nums[(int)right];
            prod = sum * (right - left + 1);
            
            while(prod >= k){
                sum -= nums[(int)left];
                left++;
                prod = sum * (right - left + 1);
            }
            
            count += (right - left + 1);
        }
        
        return count;
    }
}