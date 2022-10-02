class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        
        int i = 0;
        int j = n;
        
        int k = 0;
        while(i < n && j < 2*n){
            ans[k] = nums[i];
            ans[k+1] = nums[j];
            
            i++;
            j++;
            k = k + 2;
        }
        
        return ans;
    }
}