class Solution {
    public void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        
        int mid = left+(right-left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        
        merge(nums, left, mid, mid+1, right);
    }
    
    public void merge(int[] nums, int a1L, int a1R, int a2L, int a2R){
        int resSize = (a1R-a1L+1)+(a2R-a2L+1);
        int[] res = new int[resSize];
        
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
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
} 