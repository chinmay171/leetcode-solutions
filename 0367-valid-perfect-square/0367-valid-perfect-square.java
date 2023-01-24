class Solution {
    // public int binarySearch(int n){
    //     if(n == 0) return 0;
    //     long left = 1L;
    //     long right = n;
    //     long ans = 1L;
    //     while(left <= right){
    //         long mid = left+(right-left)/2L;
    //         long square = mid*mid;
    //         if(square == n){
    //             return (int)mid;
    //         }else if(square < n){
    //             ans = mid;
    //             left = mid+1;
    //         }else{
    //             right = mid-1;
    //         }
    //     }
    //     return (int)ans;
    // }
    public int countPerfectSquare(int num){
        int count = 0;
        for(long i = 1; i*i <= num; ++i){
            if(num % i != 0) continue;
            count++;
            if(i != num / i) count++; 
        }
        return count;
    }
    public boolean isPerfectSquare(int num) {
        // int sqrOfNum = binarySearch(num);
        // if(sqrOfNum * sqrOfNum == num)return true;
        // return false;
        int count = countPerfectSquare(num);
        if(count % 2 == 1) return true;
        return false;
    }
}