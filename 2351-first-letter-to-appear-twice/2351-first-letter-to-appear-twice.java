class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            if(hm.containsKey(s.charAt(i)) == true){
                return s.charAt(i);
            }
            hm.put(s.charAt(i), 1);
        }
        
        return s.charAt(0);
    }
}