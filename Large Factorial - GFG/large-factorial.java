//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(str[i]);
            }

            Solution ob = new Solution();
            
            long res[] = ob.factorial(a,n);
            
            for (int i=0; i<n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long[] factorial(long arr[], int n) {
        long[] fact = new long[100005];
        fact[0] = fact[1] = 1;
        for(int i = 2; i < fact.length; ++i){
            fact[i] = (fact[i-1] * i) % 1000000007;
        }
        
        long[] ans = new long[n];
        for(int i = 0; i < n; ++i){
            ans[i] = fact[(int)arr[i]];
        }
        return ans;
    }
}