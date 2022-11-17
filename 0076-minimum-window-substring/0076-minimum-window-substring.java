class Solution {
    public String minWindow(String s, String t) {
        
        String res = "";
        
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        
        int j = -1;
        HashMap<Character, Integer> sMap = new HashMap<>();
        int count = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            if(sMap.getOrDefault(ch, 0) <= tMap.getOrDefault(ch, 0)){
                count++;
            }
            
            while(count == t.length() && j < i){
                String curr = s.substring(j+1, i+1);
                if(res.length() == 0 || res.length() > curr.length()){
                    res = curr;
                }
                
                j++;
                char chr = s.charAt(j);
                sMap.put(chr, sMap.get(chr) - 1);
                if(sMap.getOrDefault(chr, 0) < tMap.getOrDefault(chr, 0)){
                    count--;
                }
            }
            
        }
        
        return res;
        
    }
}