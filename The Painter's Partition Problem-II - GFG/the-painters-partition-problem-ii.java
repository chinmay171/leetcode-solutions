//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        long lta = Long.MIN_VALUE;
        long hta = 0;
        for(int a : arr){
            lta = Math.max(lta, a);
            hta += a;
        }
        
        while(lta < hta){
            long ta = lta + (hta - lta) / 2;
            
            long partitions = 1l;
            long canPaint = 0;
            for(int a : arr){
                if(canPaint + a <= ta){
                    canPaint += a;
                }else{
                    canPaint = a;
                    partitions++;
                }
            }
            
            if(partitions > k){
                lta = ta + 1;
            }else{
                hta = ta;
            }
        }
        
        return lta;
    }
}


