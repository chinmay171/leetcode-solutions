class Solution {
    public int subtractProductAndSum(int n) {
        int temp = n;
        
        int sum = 0;
        int prod = 1;
        while(temp > 0){
            int curr = temp % 10;
            temp = temp / 10;
            
            sum += curr;
            prod *= curr;
        }
        
        int diff = prod - sum;
        return diff;
    }
}