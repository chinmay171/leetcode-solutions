class Solution {
    public int floorSqrt(int n){
        if(n == 0) return 0;
        long left = 1L;
        long right = n;
        long ans = 1L;
        while(left <= right){
            long mid = left+(right-left)/2L;
            long square = mid*mid;
            if(square == n){
                return (int)mid;
            }else if(square < n){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return (int)ans;
    }
    public boolean isPerfectSquare(int num) {
        int sqrOfNum = floorSqrt(num);
        if(sqrOfNum * sqrOfNum == num)return true;
        return false;
    }
}