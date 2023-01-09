class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        
        char[] chs = s.toCharArray();
        for(char ch : chs) freq[ch-'a']++;
        
        StringBuilder str = new StringBuilder();
        for(char ch : chs){
            freq[ch-'a']--;
            if(vis[ch-'a'] == true) continue;
            vis[ch-'a'] = true;
            
            while(str.length() > 0){
                char top = str.charAt(str.length() - 1);
                if(top > ch && freq[top-'a'] > 0){
                    str.deleteCharAt(str.length() - 1);
                    vis[top-'a'] = false;
                }else break;
            }
            
            str.append(ch);
        }
        
        return str.toString();
    }
}