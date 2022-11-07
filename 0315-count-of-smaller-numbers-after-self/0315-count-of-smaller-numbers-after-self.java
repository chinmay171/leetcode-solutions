class Solution {
    
    int[] res;

    class Pair{
        int val;
        int idx;

        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    
    public List<Integer> countSmaller(int[] nums) {
        
        Pair[] pair = new Pair[nums.length];
        for(int i = 0; i < nums.length; ++i){
            pair[i] = new Pair(nums[i], i);
        }
        
        res = new int[nums.length];
        
        mergeSort(nums, 0, nums.length - 1);
        
        List<Integer> finalRes = new ArrayList<>();
        for(int i = 0; i < res.length; ++i){
            finalRes.add(res[i]);
        }
        
        return finalRes;
    }
    
    Pair[] mergeSort(int[] nums, int lo, int hi){
        
        if(lo == hi){
            Pair[] base = new Pair[1];
            base[0] = new Pair(nums[lo], lo);
            return base;
        }
        
        int mid = lo + (hi - lo) / 2;
        Pair[] leftPart = mergeSort(nums, lo, mid);
        Pair[] rightPart = mergeSort(nums, mid + 1, hi);
        
        Pair[] currPart = merge2(leftPart, rightPart);
        
        return currPart;
    }
    
    public Pair[] merge2(Pair[] firstArray, Pair[] secondArray){
        
        Pair[] ret = new Pair[firstArray.length + secondArray.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < firstArray.length && j < secondArray.length){
            if(firstArray[i].val > secondArray[j].val){
                ret[k] = firstArray[i];
                
                res[firstArray[i].idx] += secondArray.length - j;
                
                i++;
                k++;
            }else{
                ret[k] = secondArray[j];
                
                j++;
                k++;
            }
        }
        
        while(i < firstArray.length){
            ret[k] = firstArray[i];
            i++;
            k++;
        }
        while(j < secondArray.length){
            ret[k] = secondArray[j];
            j++;
            k++;
        }
        
        return ret;
        
    }
}