class Solution {
    
    public int gcd(int a, int b){
        if(b == 0)return a;
        return gcd(b , a % b);
    }
    
    public int findGCD(int[] nums) {
        
        int max = 0;
        int min = 1001;
        for(int val : nums){
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        
        return gcd(max, min);
    }
}