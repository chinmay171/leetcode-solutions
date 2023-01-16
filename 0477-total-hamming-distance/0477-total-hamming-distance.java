class Solution {
    public int totalHammingDistance(int[] nums) {
        // approach 1  O(n2)
        // int sum = 0;
        // for(int a : nums){
        //     for(int b : nums){
        //         sum += Integer.bitCount(a ^ b);
        //     }
        // }
        // return sum >> 1;
        
        int sum = 0;
        
        for(int bit = 0; bit < 32; ++bit){
            int zero = 0;
            int ones = 0;
            for(int num : nums){
                if((num & ( 1 << bit)) != 0) ones++;
                else zero++;
            }
            
            sum = sum + ones*zero;
        }
        
        return sum;
    }
}