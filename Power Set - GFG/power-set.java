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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // List<String> ans = new ArrayList<>();
    // public void recursion(String input, int idx, String output){
    //     if(idx >= input.length()){
    //         if(output.length() > 0) ans.add(output);
    //         return;
    //     }
        
    //     //yes
    //     recursion(input, idx+1, output + input.charAt(idx));
    //     //no
    //     recursion(input, idx+1, output);
    // }
    public List<String> AllPossibleStrings(String s)
    {
        // recursion(s, 0, "");
        // Collections.sort(ans);
        // return ans;
        List<String> res = new ArrayList<>();
        int n = s.length();
        for(int decimal = 1; decimal < (1 << n); ++decimal){
            String subset = "";
            for(int bit = 0; bit < n; ++bit){
                if((decimal & (1 << bit)) != 0){
                    subset += (s.charAt(bit));
                }
            }
            res.add(subset);
        }
        Collections.sort(res);
        return res;
    }
}