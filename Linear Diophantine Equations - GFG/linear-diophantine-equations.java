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
            String S[] = read.readLine().split(" ");
            int A = Integer.parseInt(S[0]);
            int B = Integer.parseInt(S[1]);
            int N = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            System.out.println(ob.isPossible(A,B,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    static int isPossible(int A,int B, int C){
        int g = gcd(A, B);
        if(C % g == 0) return 1;
        return 0;
    }
}