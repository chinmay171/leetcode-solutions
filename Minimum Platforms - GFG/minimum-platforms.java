//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    public static class pair{
        int arrTime;
        int depTime;

        public pair(int arrTime, int depTime){
            this.arrTime = arrTime;
            this.depTime = depTime;
        }
    }
    static int findPlatform(int at[], int dt[], int n)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pair[] atdt = new pair[n];
        for(int i = 0; i < n; ++i){
            pair curr = new pair(at[i], dt[i]);
            atdt[i] = curr;
        }

        Arrays.sort(atdt, (pair a, pair b) ->
                        a.arrTime - b.arrTime);

        int platforms = 0;
        for(int i = 0; i < n; ++i){
            if(pq.size() == 0){
                pq.add(atdt[i].depTime);
            }else{
                while(pq.size() > 0 && pq.peek() < atdt[i].arrTime) pq.remove();
                pq.add(atdt[i].depTime);
            }
            platforms = Math.max(platforms, pq.size());
        }

        return platforms;
    }
    
}

