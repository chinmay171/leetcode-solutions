// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isMinimum(int[] nums, int mid){
        int lval = (mid - 1 < 0)
            ? Integer.MAX_VALUE : nums[mid-1];
        int rval = (mid + 1 >= nums.length)
            ? Integer.MAX_VALUE : nums[mid+1];
        if(nums[mid] < lval && nums[mid] < rval)return true;
        return false;
    }
    public boolean isMaximum(int[] nums, int mid){
        int lval = (mid - 1 < 0)
            ? Integer.MIN_VALUE : nums[mid-1];
        int rval = (mid + 1 >= nums.length)
            ? Integer.MIN_VALUE : nums[mid+1];
        if(nums[mid] > lval && nums[mid] > rval)return true;
        return false;
    }
    int findKRotation(int arr[], int n) {
        // code here
    
        int left = 0; 
        int right = arr.length-1;
        if(arr[left] < arr[right])return 0;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(isMinimum(arr,mid)){
                return mid;
            }else if(isMaximum(arr,mid)){
                return mid+1;
            }else if(arr[left] < arr[mid]){
                left = mid+1;
            }else if(arr[mid]  < arr[right]){
                right = mid-1;
            }
        }
        return 1;
    }
}