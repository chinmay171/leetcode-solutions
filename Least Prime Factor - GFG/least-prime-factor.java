//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        int[] lpf = new int[n+1];
        for(int i = 1; i <= n; ++i) lpf[i] = i;
        for(int i = 2; i <= n; ++i){
            if(lpf[i] != i)continue;
            for(long j = 1l*i*i; j <= n; j = j+i) if(lpf[(int)j] == j) lpf[(int)j] = i;
        }
        return lpf;
    }
}