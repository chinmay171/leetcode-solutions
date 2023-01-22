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
            int a[] = new int[n];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.largest(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Compute {
    public int recursion(int ans, int i, int[] arr, int n){
        if(i >= n) return ans;
        int temp = Math.max(ans, arr[i]);
        return recursion(temp, i+1, arr, n);
    }
    public int largest(int arr[], int n)
    {
        return recursion(Integer.MIN_VALUE, 0, arr, n);
    }
}