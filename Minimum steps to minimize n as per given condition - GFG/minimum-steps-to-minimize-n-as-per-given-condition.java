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
                    Solution ob = new Solution();
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    // } Driver Code Ends


class Solution{
    
    public int minSwaps(int N, int[] dp){
        if(N == 1)return 0;
	    if(dp[N] != -1){
	        return dp[N];
	    }
	    int steps = 1;
	    int divBy2 = Integer.MAX_VALUE;
	    int divBy3 = Integer.MAX_VALUE;
	    if(N % 2 == 0){
	        divBy2 = minSwaps(N/2, dp);
	    }
	    if(N % 3 == 0){
	        divBy3 = minSwaps(N/3, dp);
	    }
	    int Subtract1 = minSwaps(N-1, dp);
	    
	    return dp[N] = Math.min(Math.min(divBy2, divBy3), Subtract1)+1;
    }
	public int minSteps(int N) 
	{ 
	    // Your code goes here
	    int[] dp = new int[N+1];
	    Arrays.fill(dp, -1);
	    return minSwaps(N, dp);
	} 
}
