class Solution {
    
    public boolean check(int[] req, int[] curr){
        for(int i = 0; i < 26; ++i){
            if(req[i] != curr[i]){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length() < s1.length()){
            return false;
        }
        
        int[] reqArr = new int[26];
        for(int i = 0; i < s1.length(); ++i){
            reqArr[s1.charAt(i) - 'a']++;
        }
        
        int[] currArr = new int[26];
        for(int i = 0; i < s1.length(); ++i){
            currArr[s2.charAt(i) - 'a']++;
        }
        
        if(check(reqArr, currArr) == true) return true;
        
        for(int i = s1.length(); i < s2.length(); ++i){
            // adding char to currArr
            currArr[s2.charAt(i) - 'a']++;
            
            // removing char from currArr
            currArr[s2.charAt(i-s1.length()) - 'a']--;
            
            if(check(reqArr, currArr) == true) return true;
        }
        
        return false;
    }
}