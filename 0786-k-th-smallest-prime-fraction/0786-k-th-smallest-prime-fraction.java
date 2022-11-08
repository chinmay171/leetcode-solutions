class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0.0;
        double hi = 1.0;
        
        while(lo <= hi){
            
            double mid = lo + (hi - lo) / 2;
            int p = 0;
            int q = 1;
            
            int actual = 0;
            int j = 0;
            for(int i = 0; i < arr.length; ++i){
                while(j < arr.length && arr[i] * 1.0 / arr[j] > mid){
                    j++;
                }
                
                if(j == arr.length) break;
                
                actual += (arr.length - j);
                
                if(arr[i] * 1.0 / arr[j] > p * 1.0 / q){
                    p = arr[i];
                    q = arr[j];
                }
            }
            
            if(actual < k){
                lo = mid;
            }else if(actual > k){
                hi = mid;
            }else{
                return new int[]{p, q};
            }
        }
        
        return null;
    }
}