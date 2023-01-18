class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for(int bit = 0; bit < 32; ++bit){
            int counter = 0;
            int mask = (1 << bit);
            for(int num : nums){
                if((num & mask) != 0){
                    counter++;
                }
            }
            
            if(counter % 3 != 0){
                res = (res | mask);
            }
        }
        
        return res;
    }
}