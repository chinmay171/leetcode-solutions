class Solution {
    public int arraySign(int[] nums) {
        int negative = 0;
        for(int num : nums){
            if(num < 0) negative++;
            if(num == 0) return 0;
        }
        if(negative % 2 == 1) return -1;
        return 1;
    }
}