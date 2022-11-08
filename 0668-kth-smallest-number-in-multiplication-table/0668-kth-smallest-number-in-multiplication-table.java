class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m * n;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            //actual;
            int actual = 0;
            int j = n;
            for(int i = 1; i <= m; ++i){
                while(j >= 1 &&  i*j > mid){
                    j--;
                }
                actual += j;
            }
            
            if(actual < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
}