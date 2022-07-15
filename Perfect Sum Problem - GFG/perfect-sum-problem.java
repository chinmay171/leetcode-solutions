// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{
    
    // public int memo(int idx, int[] arr, int target, int[][] dp){
    //     if(target < 0)return 0;
    //     if(idx == arr.length){
    //         if(target == 0)return 1;
    //         return 0;
    //     }
    //     if(dp[idx][target] != -1)return dp[idx][target];
    //     int no = memo(idx+1, arr, target, dp);
    //     int yes = memo(idx+1, arr, target-arr[idx], dp);
    //     return dp[idx][target] = (no+yes)%1000000007 ;
    // }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	   // int[][] dp = new int[arr.length+1][sum+1];
	   // for(int i = 0; i<=arr.length; ++i){
	   //     for(int j = 0; j<=sum; ++j){
	   //         dp[i][j] = -1;
	   //     }
	   // }
	   // return memo(0, arr, sum, dp);
	   
	   int[] dp = new int[sum+1];
	   
	   
	   dp[0] = 1;
	   
	   for(int i = 1; i<= n; ++i){
	       int[] newdp = new int[sum+1];
	       for(int j = 0; j<= sum; ++j){
	           int no  = dp[j];
	           int yes = (j >= arr[i-1]) ? dp[j-arr[i-1]] : 0;
	           
	           newdp[j] = (yes + no)% 1000000007;
	       }
	       dp = newdp;
	   }
	   
	   return dp[sum];
	} 
}