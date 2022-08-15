class Solution {
    public boolean isAnagram(int[] freq){
        for(int i = 0; i < 26; ++i) if(freq[i] != 0)return false;
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        
        for(int i = 0; i < p.length(); ++i) freq[p.charAt(i) - 'a']--;
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i){
            
            freq[s.charAt(i) - 'a']++;
            
            int l = i - p.length();
            if(l >= 0)freq[s.charAt(l) - 'a']--;
            if(isAnagram(freq) == true)res.add(l+1);
        }
        return res;
    }
}