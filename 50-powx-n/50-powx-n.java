class Solution {
    public double myPowHelper(double x, int n){
        if(n == 0)return 1.0;
        double temp = myPowHelper(x, n/2);
        if(n%2 == 0){
            return temp*temp;
        }else{
            return temp*temp*x;
        }
    }
    public double myPow(double x, int n) {
        if(x == 0)return 0.0;
        if(x == 1)return 1.0;
        if(n < 0){
            return 1.0/myPowHelper(x, -n);
        }
        return myPowHelper(x, n);
    }
}