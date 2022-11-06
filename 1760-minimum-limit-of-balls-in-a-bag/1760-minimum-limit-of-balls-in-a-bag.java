class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int h = Integer.MIN_VALUE;
        
        for(int num : nums){
            h = Math.max(h, num);
        }
        
        while(l < h){
            int mid = l + (h - l) / 2;
            
            int opsReq = 0;
            for(int num : nums){
                if(num > mid){
                    int spare = num - mid;
                    int ceil = (spare + mid - 1) / mid;
                    opsReq += ceil;
                }
            }
            
            if(opsReq > maxOperations){
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        
        return l;
    }
}