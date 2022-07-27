class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        
        for(int i = 0; i<s.length(); ++i){
            //for odd length
            int left = i-1, right = i+1, len = 1;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    len += 2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            if(res.length() < len){
                res = s.substring(left+1, left+1+len);
            }
        }
        
        for(int i = 0; i<s.length(); ++i){
            //for even length
            if(i+1 == s.length() || s.charAt(i)!=s.charAt(i+1)){
                continue;
            }
            int left = i-1, right = i+2, len = 2;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    len += 2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            if(res.length() < len){
                res = s.substring(left+1, left+1+len);
            }
        }
        
        return res;
    }
}