// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    // static int memo(int cap, int item, int[] wt, int[] cost, int[][] dp){
    //     if(item == cost.length)return 0;
    //     if(dp[cap][item] != -1)return dp[cap][item];
    //     int yes = (cap >= wt[item]) ? memo(cap-wt[item], item+1, wt, cost, dp)+cost[item] : -1;
    //     int no = memo(cap, item +1, wt, cost, dp); 
        
    //     return dp[cap][item] = Math.max(yes, no);
    // }
    static int knapSack(int caps, int wt[], int cost[], int n) 
    { 
         // your code here 
        //  int[][] dp = new int[Capacity+1][val.length];
        //  for(int i = 0; i<=Capacity; ++i){
        //      for(int j = 0; j<val.length; ++j){
        //          dp[i][j] = -1;
        //      }
        //  }
        //  return memo(Capacity, 0, wt, val, dp);
        
        int[][] dp = new int[caps+1][cost.length+1];
        
        for(int item = 1; item <= cost.length; ++item){
            for(int cap = 1; cap<= caps; ++cap){
                int no = dp[cap][item-1];
                int yes = (cap >= wt[item-1])
                            ? cost[item-1] + dp[cap-wt[item-1]][item-1]
                            : -1;
                dp[cap][item] = Math.max(yes, no);
            }
        }
        return dp[caps][cost.length];
    } 
}


