class Solution {

    public int[] sortingTwoArray(int[] leftArray, int[] rightArray){
        int[] afterSorting = new int[leftArray.length + rightArray.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] < rightArray[j]){
                afterSorting[k] = leftArray[i];
                i++;
            }else{
                afterSorting[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < leftArray.length){
            afterSorting[k] = leftArray[i];
            i++;
            k++;
        }
        while(j < rightArray.length){
            afterSorting[k] = rightArray[j];
            j++;
            k++;
        }

        return afterSorting;
    }

    public int[] mergeSort(int[] nums, int left, int right){
        if(left == right) return new int[]{nums[left]};

        int mid = (left + right) / 2;
        int[] leftSortedArray = mergeSort(nums,left, mid);
        int[] rightSortedArray = mergeSort(nums, mid + 1, right);

        return sortingTwoArray(leftSortedArray, rightSortedArray);
    }

    public int[] sortArray(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
        
        // SELECTION SORT       
        // for(int i = 0; i < nums.length; ++i){
        //     int minIdx = i;
        //     for(int j = i + 1; j < nums.length; ++j)
        //         if(nums[minIdx] > nums[j]) minIdx = j;
        //     int temp = nums[i];
        //     nums[i] = nums[minIdx];
        //     nums[minIdx] = temp;
        // }
        // return nums;

        // BUBBLE SORT
        // for(int i = 0; i < nums.length; ++i){
        //     for(int j = 0; j < nums.length-i-1; ++j){
        //         if(nums[j] > nums[j+1]){
        //             int temp = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = temp;
        //         }
        //     }
        // }
        // return nums;

        // INSERTION SORT
        // for(int i = 0; i < nums.length; ++i){
        //     int j = i;
        //     while(j > 0 && nums[j-1] > nums[j]){
        //         int temp = nums[j];
        //         nums[j] = nums[j-1];
        //         nums[j-1] = temp;

        //         j--;
        //     }
        // }
        // return nums;
    }
}