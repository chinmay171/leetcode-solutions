class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // int[] ptr = new int[primes.length];
        // ArrayList<Long> ugly = new ArrayList<>();
        // ugly.add(1l);
        // for(int i = 1; i< n; ++i){
        //     Long m = Long.MAX_VALUE;
        //     for(int j = 0; j< primes.length; ++j){
        //         m = Math.min(m, ugly.get(ptr[j]) * primes[j]);
        //     }
        //     ugly.add(m);
        //     for(int j = 0; j< primes.length; ++j){
        //         if(ugly.get(ptr[j]) * primes[j] == m){
        //             ptr[j]++;
        //         }
        //     }
        // }
        // return ugly.get((long)n-1);
        
        long[] primes1 = new long[primes.length];
        for(int i = 0 ;i< primes.length;i++) {
            primes1[i] = primes[i];
        }
        int[] index = new int[primes.length];
        long[] n1= new long[n];
        n1[0] = 1L;
        for(int i = 1; i< n;i++) {
            long min = Long.MAX_VALUE;
            for(int j=0;j < primes1.length;j++) {
                min= Math.min(min,primes1[j]);

            }
            n1[i] = min;
            for(int j =0 ; j< primes1.length;j++) {
                if(min == primes1[j]) {
                    primes1[j] = primes[j] * (n1[++index[j]]);
                }
            }
        }
        return (int)n1[n - 1];
        
    }
}