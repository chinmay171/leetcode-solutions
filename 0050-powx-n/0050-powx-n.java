class Solution {
    // public double myPowHelper(double x, int n){
    //     if(n == 0)return 1.0;
    //     double temp = myPowHelper(x, n/2);
    //     if(n%2 == 0){
    //         return temp*temp;
    //     }else{
    //         return temp*temp*x;
    //     }
    // }
    public double myPow(double x, int n) {
        // if(x == 0)return 0.0;
        // if(x == 1)return 1.0;
        // if(n < 0){
        //     return 1.0/myPowHelper(x, -n);
        // }
        // return myPowHelper(x, n);
        
        double ans = 1.0;
        long pow = n;
        
        if(pow < 0){
            x = 1.0 / x;
            pow = - pow;
        }
        
        for(int bit = 0; bit < 64; ++bit){
            if((pow & (1l << bit)) != 0){
                ans = ans * x;
            }
            x = x * x;
        }
        
        return ans;
    }
}