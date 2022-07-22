class Solution {
    public int longestMountain(int[] arr) {
        int[] left = new int[arr.length];
        Arrays.fill(left, 1);
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > arr[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        int[] right = new int[arr.length];
        Arrays.fill(right, 1);
        for(int i = arr.length-2; i>=0; i--){
            if(arr[i] > arr[i+1]){
                right[i] = right[i+1]+1;
            }
        }
        
        int max = 0;
        for(int i = 0; i<arr.length; i++){
            if(left[i] > 1 && right[i] > 1){
                int curr = left[i] + right[i] - 1;
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}