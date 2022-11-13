class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length <= 2) return false;
        
        int idx1 = 0;
        int idx2 = 1;
        int idx3 = 2;
        
        while(idx3 < arr.length){
            
            if(arr[idx1] % 2 == 1 && arr[idx2] % 2 == 1 && arr[idx3] % 2 == 1){
                return true;
            }
            
            idx1++;
            idx2++;
            idx3++;
        }
        
        return false;
    }
}