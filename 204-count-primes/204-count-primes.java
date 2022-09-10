class Solution {
    public int countPrimes(int n) {
        if(n < 2)return 0;
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i*i < n; ++i){
            if(isPrime[i] == false)continue;
            
            for(long j = 1l*i*i; j < n; j = j+i){
                isPrime[(int)j] = false;
            }
        }
        
        int count = 0; 
        for(int i = 2; i < isPrime.length; ++i){
            if(isPrime[i] == true)
                count++;
        }
        
        return count;
    }
}