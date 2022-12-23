class Solution {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); ++i){
            freq[s.charAt(i)-'a']++;
        }
        
        boolean isValid = true;
        int start = 0;
        int maxLen = 0;
        for(int end = 0; end < s.length(); ++end){
            if(freq[s.charAt(end)-'a'] > 0 && freq[s.charAt(end)-'a'] < k){
                maxLen = Math.max(maxLen, longestSubstring(s.substring(start, end), k));
                start = end+1;
                isValid = false;
            }
        }
        
        if(isValid == true){
            return s.length();
        }
        return Math.max(maxLen, longestSubstring(s.substring(start), k));
    }
}