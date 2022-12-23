class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        
        if(k == 0) return nums;
        if(2*k+1 > nums.length){
            Arrays.fill(ans, -1);
            return ans;
        }
        
        int right = 0;
        long sumWin = 0;
        long winSize = 2*k + 1;

        while(right < winSize){
            sumWin += nums[right];
            right++;
        }

        for(int i = 0; i < nums.length; ++i){
            if(i < k || i >= nums.length - k) ans[i] = -1;
            else{
                long avg = sumWin / winSize;
                ans[i] = (int)avg;
                if(i == nums.length-k-1) continue;
                sumWin += nums[i+k+1];
                sumWin -= nums[i-k];
            }
        }
        
        return ans;
        
    }
}