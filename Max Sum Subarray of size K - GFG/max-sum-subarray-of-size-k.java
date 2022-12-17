//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        
        long maxSum = 0;
        long currSum = 0;
        for(int i = 0; i < N; ++i){
            if(i < K){
                maxSum += (long)Arr.get(i);
                currSum = maxSum;
            }else{
                currSum = currSum + (long)Arr.get(i) - (long)Arr.get(i-K);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        
        return maxSum;
        
        // long currSum = 0;
        // for(int i = 0; i < K; ++i){
        //     currSum += Arr.get(i);
        // }
        
        // long maxSum = currSum;
        // for(int i = K; i < N; ++i){
        //     currSum = max
        // }
        
    }
}