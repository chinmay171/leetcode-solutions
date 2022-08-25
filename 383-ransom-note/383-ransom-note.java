class Solution {
    public boolean canConstruct(String small, String big) {
        if(small.length() > big.length())return false;
        
        int[] freq = new int[26];
        
        for(int i = 0; i < big.length(); ++i){
            freq[big.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < small.length(); ++i){
            freq[small.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < 26; ++i){
            if(freq[i] < 0)return false;
        }
        return true;
    }
}