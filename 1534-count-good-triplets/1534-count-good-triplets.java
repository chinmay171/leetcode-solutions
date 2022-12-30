class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int i=0,j=i+1,k=j+1;
        
        while(k < arr.length){
            if(Math.abs(arr[i]-arr[j]) <= a &&
               Math.abs(arr[j]-arr[k]) <= b &&
               Math.abs(arr[i]-arr[k]) <= c) count++;
            if(k < arr.length-1) k++;
            else if(k == arr.length-1 && j < arr.length-2){j++;k=j+1;} 
            else if(j == arr.length-2){i++;j=i+1;k=j+1;} 
        } 
        
        return count;
    }
}