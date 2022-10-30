class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        int maxProd = 0;
        
        for(int i = 0; i < nums.length; ++i){
            int maxProdForI = nums[i];
            maxProd = Math.max(maxProd, maxProdForI);
            for(int j = i+1; j < nums.length; ++j){
                maxProdForI = maxProdForI * nums[j];
                maxProd = Math.max(maxProd, maxProdForI);
            }
        }
        
        return maxProd;
    }
}