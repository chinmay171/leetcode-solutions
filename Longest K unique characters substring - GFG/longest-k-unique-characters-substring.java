//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int maxLen = -1;
        int left = 0;
        
        HashMap<Character, Integer> window = new HashMap<>();
        
        for(int right = 0; right < s.length(); ++right){
            char ch = s.charAt(right);
            
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if(window.size() == k) maxLen =  Math.max(maxLen, right - left + 1);
            
            while(window.size() > k){
                char chL = s.charAt(left);
                window.put(chL, window.getOrDefault(chL, 0) - 1);
                if(window.get(chL) == 0) window.remove(chL);
                left++;
                if(window.size() <= k) maxLen =  Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }
}