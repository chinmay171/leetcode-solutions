class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        
        for(int val : nums){
            int currSum = 0, count = 0;
            
            for(int i = 1; i*i <= val; ++i){
                if(val % i == 0){
                    currSum += i;
                    count++;
                    if(i != val/i){
                        currSum += (val / i);
                        count++;
                    }
                }
            }
            if(count == 4) sum += currSum;
        }       
        return sum;
    }
}