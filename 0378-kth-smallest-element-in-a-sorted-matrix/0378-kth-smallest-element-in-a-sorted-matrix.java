class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1];
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            // actual
            int actual = 0;
            int j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; ++i){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                actual += (j + 1);
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