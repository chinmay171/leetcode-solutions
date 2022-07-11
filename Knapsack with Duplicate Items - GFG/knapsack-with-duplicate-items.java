// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    // static int memo(int n,int idx, int caps, int[] profit, int[] Itemwt, int[][] dp){
    //     if(idx == n)return 0;
    //     if(dp[idx][caps] != -1)return dp[idx][caps];
    //     int yes = 0;
    //     if(caps >= Itemwt[idx]){
    //         yes = memo(n,idx, caps- Itemwt[idx], profit, Itemwt, dp) + profit[idx];
    //     }
    //     int no = memo(n, idx+1, caps, profit, Itemwt, dp);
    //     return dp[idx][caps] =Math.max(yes, no);
    // }
    static int knapSack(int N, int caps, int profit[], int Itemwt[])
    {
        // code here
        // int[][] dp = new int[N+1][caps+1];
        // for(int i = 0; i<= N; ++i){
        //     for(int j = 0; j<=caps; ++j){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memo(N,0, caps, profit, Itemwt,dp);
        
        int[] dp = new int[caps+1];
        
        for(int item = 1; item<= N; ++item){
            for(int cap = 1; cap <= caps; ++cap){
                int no = dp[cap];
                int yes = (cap >= Itemwt[item-1])
                            ? dp[cap- Itemwt[item-1]] + profit[item-1]
                            : -1;
                
                dp[cap] = Math.max(no, yes);
            }
        }
        return dp[caps];
    }
}