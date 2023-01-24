class Solution {
    public boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i = 2; i*i <= n; ++i) if(n % i == 0) return false;
        return true;
    }
    public boolean isThree(int n) {
        int sqrt = (int)Math.sqrt(n);
        if(sqrt*sqrt != n) return false;
        return isPrime(sqrt);
    }
}