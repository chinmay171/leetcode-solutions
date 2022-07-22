class Solution {
    public int longestMountain(int[] arr) {
//         int[] left = new int[arr.length];
//         Arrays.fill(left, 1);
//         for(int i = 1; i<arr.length; i++){
//             if(arr[i] > arr[i-1]){
//                 left[i] = left[i-1]+1;
//             }
//         }
//         int[] right = new int[arr.length];
//         Arrays.fill(right, 1);
//         for(int i = arr.length-2; i>=0; i--){
//             if(arr[i] > arr[i+1]){
//                 right[i] = right[i+1]+1;
//             }
//         }
        
//         int max = 0;
//         for(int i = 0; i<arr.length; i++){
//             if(left[i] > 1 && right[i] > 1){
//                 int curr = left[i] + right[i] - 1;
//                 max = Math.max(max, curr);
//             }
//         }
//         return max;
        
        int max = 0;
        for(int i = 0;i<arr.length; ++i){
            if(i > 0 && i < arr.length-1 && arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                int curr = 1;
                
                int left = i-1;
                while(left >= 0 && arr[left] < arr[left+1]){
                    left--;
                    curr++;
                }
                int right = i+1;
                while(right < arr.length && arr[right] < arr[right-1]){
                    right++;
                    curr++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}