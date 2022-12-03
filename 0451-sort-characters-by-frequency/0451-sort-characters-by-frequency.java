class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq1 = new HashMap<>();
        for(int i = 0; i<s.length(); ++i){
            char ch = s.charAt(i);
            freq1.put(ch, freq1.getOrDefault(ch, 0)+1);
        }
        
        HashMap<Integer, ArrayList<Character>> freq2 = new HashMap<>();
        for(Character ch : freq1.keySet()){
            int f = freq1.get(ch);
            if(freq2.containsKey(f) == false)
                freq2.put(f, new ArrayList<>());
            freq2.get(f).add(ch);
        }
        
        StringBuilder ans = new StringBuilder("");
        for(int f = s.length(); f>=1; --f){
            if(freq2.containsKey(f) == true){
                for(Character ch : freq2.get(f)){
                    for(int i = 0; i<f; ++i){
                        ans.append(ch);
                    }
                }
            }
        }
        
        return ans.toString();
    }
}