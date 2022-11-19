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
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int num, int den)
    {
        // code here
        int quo = num / den;
        int rem = num % den;
        
        if(rem == 0){
            return quo + "";
        }
        
        String ans = quo + ".";
        String frac = "";
        
        HashMap<Integer, Integer> map = new HashMap<>();
        while(rem != 0 && map.containsKey(rem) == false){
            
            map.put(rem, frac.length());
            
            num = rem * 10;
            quo = num / den;
            rem = num % den;
            
            frac += quo;
        }
        
        if(rem == 0){
            ans += frac;
        }else{
            int idx = map.get(rem);
            ans += frac.substring(0, idx) + "(" + frac.substring(idx) + ")";
        }
        
        return ans;
    }
}