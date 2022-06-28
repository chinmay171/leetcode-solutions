// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countSwaps(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
     public static int mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return 0;
        }
        
        int mid = left+(right-left)/2;
        int l = mergeSort(nums, left, mid);
        int r = mergeSort(nums, mid+1, right);
        int m = merge(nums, left, mid, mid+1, right);
        return (l+r+m);
    }
    
    public static int merge(int[] nums, int a1L, int a1R, int a2L, int a2R){
        int resSize = (a1R-a1L+1)+(a2R-a2L+1);
        int[] res = new int[resSize];
        
        int inv = 0;
        int i = a1L; 
        int j = a2L; 
        int k = 0;
        while(i <= a1R && j <= a2R){
            if(nums[i] <= nums[j]){
                res[k] = nums[i];
                i++;
                k++;
            }else{
                inv += (a1R-i+1);
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
    int countSwaps(int arr[], int n) {
        // code here
        return mergeSort(arr, 0, n-1);
    }
}