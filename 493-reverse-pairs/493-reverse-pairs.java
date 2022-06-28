class Solution {
    public int mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return 0;
        }
        
        int mid = left+(right-left)/2;
        int l = mergeSort(nums, left, mid);
        int r = mergeSort(nums, mid+1, right);
        int a = merge(nums, left, mid, mid+1, right);
        return (l+r+a);
    }
    
    public int findInv(int[] nums, int a1L, int a1R, int a2L, int a2R){
        int i = a1L; 
        int j = a2L; 
        int k = 0;
        int invCount = 0;
        while(i <= a1R && j <= a2R){
            if(nums[i] <= 2l*nums[j]){
                i++;
                k++;
            }else{
                invCount += (a1R-i+1);
                j++;
                k++;
            }
        }
        return invCount;
    }
    
    public int merge(int[] nums, int a1L, int a1R, int a2L, int a2R){
        int resSize = (a1R-a1L+1)+(a2R-a2L+1);
        int[] res = new int[resSize];
        int inv = findInv(nums, a1L, a1R, a2L, a2R);
        int i = a1L; 
        int j = a2L; 
        int k = 0;
        while(i <= a1R && j <= a2R){
            if(nums[i] <= nums[j]){
                res[k] = nums[i];
                i++;
                k++;
            }else{
                res[k] = nums[j];
                j++;
                k++;
            }
        }
        while(i <= a1R){
            res[k] = nums[i];
                i++;
                k++;
        }
        while(j <= a2R){
            res[k] = nums[j];
                j++;
                k++;
        }
        for(int x = a1L; x <= a2R; ++x){
            nums[x] = res[x - a1L];
        }
        return inv;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}