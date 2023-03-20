class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        if(n == 0) return true;
        if(arr.length == 1){
            if(arr[0] == 1){
                return n==0;
            }else{
                n--;
                return n==0;
            }
        }
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == 1) continue;
            else{
                if(i == 0 && arr[i] == 0 && arr[i+1] == 0){
                    arr[i] = 1;
                    n--;
                }
                if(i == arr.length-1 && arr[i] == 0 && arr[i-1] == 0){
                    arr[i] = 1;
                    n--;
                }
                if(i > 0 && i < arr.length-1 && arr[i-1] != 1 && arr[i+1] != 1){
                    arr[i] = 1;
                    n--;
                }
            }
            if(n == 0) return true;
        }
        return false;
    }
}