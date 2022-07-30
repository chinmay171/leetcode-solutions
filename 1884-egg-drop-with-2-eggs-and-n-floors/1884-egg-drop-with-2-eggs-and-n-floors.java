class Solution {
    public int twoEggDrop(int n) {
        double ans = (-1.0 + Math.sqrt(1.0+8.0*n))/2.0;
        if(ans == (int)ans)return (int)ans;
        return (int)ans+1;
    }
}