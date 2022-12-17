//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long a[], int N, int K)
    {
        Deque<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < K; ++i){
            if(a[i] < 0){
                q.add(i);
            }
        }
        
        long[] ans = new long[N - K + 1];
        
        int j = 0;
        if(q.size() == 0){
            ans[j] = 0;
        }else{
            ans[j] = a[q.getFirst()];    
        }
        j++;
        
        for(int i = K; i < N; ++i){
            // adding in queue
            if(a[i] < 0){
                q.add(i);
            }
            
            // removing from queue
            if(q.size() > 0 && a[q.getFirst()] == a[i-K]){
                q.removeFirst();
            }
            
            //making ans array
            if(q.size() == 0){
                ans[j] = 0;
            }else{
                ans[j] = a[q.getFirst()];
            }
            j++;
        }
        
        return ans;
    }
}