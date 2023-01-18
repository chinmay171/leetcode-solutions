class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) xor = xor ^ num;
        
        int rsb = Integer.highestOneBit(xor);
        int first = 0;
        for(int num : nums){
            if((num & rsb) != 0){
                first = first ^ num;
            }
        }
        
        int second = xor ^ first;
        return new int[]{first, second};
    }
}