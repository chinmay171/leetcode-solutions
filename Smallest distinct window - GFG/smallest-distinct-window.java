//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        HashSet<Character> reqSet = new HashSet<>();
        
        for(int i = 0; i < str.length(); ++i){
            reqSet.add(str.charAt(i));
        }
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int matchCount = 0;
        
        HashMap<Character, Integer> window = new HashMap<>();
        for(int right = 0; right < str.length(); ++right){
            char ch = str.charAt(right);
            
            //expand
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if(window.get(ch) == 1 && reqSet.contains(ch) == true){
                matchCount++;
                if(matchCount == reqSet.size()) minLen = Math.min(minLen, right - left + 1);
            }
            
            //release
            while(matchCount >= reqSet.size()){
                char chL = str.charAt(left);
                window.put(chL, window.getOrDefault(chL, 0) - 1);
                if(window.get(chL) == 0 && reqSet.contains(chL) == true){
                    window.remove(chL);
                    matchCount--;
                }
                left++;
                if(matchCount == reqSet.size()) minLen = Math.min(minLen, right - left + 1);
            }
        }
        
        return minLen;
    }
}