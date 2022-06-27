class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            
            int lval = (mid-1 >= 0) ? arr[mid-1] : Integer.MIN_VALUE;
            int rval = (mid+1 < arr.length) ? arr[mid+1] : Integer.MIN_VALUE;
            if(arr[mid]>lval && arr[mid]>rval){
                return mid;
            }else if(arr[mid] < rval){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}