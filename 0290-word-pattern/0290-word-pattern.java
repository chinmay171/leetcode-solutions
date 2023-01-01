class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] t = s.split(" ");
        if(pattern.length() != t.length) return false;
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < pattern.length(); ++i){
            Character ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                String str = map.get(ch);
                if(str.equals(t[i]) == false) return false;
            }else{
                if(set.contains(t[i]) == true) return false;
                map.put(ch, t[i]);
                set.add(t[i]);
            } 
        }
        // System.out.println(set);
        
        return true;
    }
}