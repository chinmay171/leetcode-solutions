// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    public static long mergeSort(long[] nums, int left, int right){
        if(left >= right){
            return 0;
        }
        
        int mid = left+(right-left)/2;
        long l = mergeSort(nums, left, mid);
        long r = mergeSort(nums, mid+1, right);
        long m = merge(nums, left, mid, mid+1, right);
        return (l+r+m);
    }
    
    public static long merge(long[] nums, int a1L, int a1R, int a2L, int a2R){
        int resSize = (a1R-a1L+1)+(a2R-a2L+1);
        long[] res = new long[resSize];
        
        long inv = 0L;
        int i = a1L; 
        int j = a2L; 
        int k = 0;
        while(i <= a1R && j <= a2R){
            if(nums[i] <= nums[j]){
                res[k] = nums[i];
                i++;
                k++;
            }else{
                inv += (a1R-i+1L);
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
    
    
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
       return mergeSort(arr, 0, (int)N-1);
    }
}