class Solution {
    public int lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int ans = arr.length;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(arr[mid] >= target){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    public int closest(int[] arr, int target){
        int lb = lowerBound(arr, target);
        if(lb == arr.length){
            return arr[arr.length-1];
        }else if(lb == 0){
            return arr[0];
        }else if(Math.abs(target-arr[lb]) < Math.abs(target-arr[lb-1])){
            return arr[lb];
        }
        else{
            return arr[lb-1];
        }
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        
        int Max = Integer.MIN_VALUE;
        for(int i = 0; i<houses.length; ++i){
            int closerHeater = closest(heaters, houses[i]);
            Max = Math.max(Max,Math.abs(closerHeater-houses[i]));
        }
        return Max;
    }
}