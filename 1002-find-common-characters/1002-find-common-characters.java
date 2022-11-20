class Solution {
    public List<String> commonChars(String[] words) {
        
        HashMap<Character, Integer> finalMap = new HashMap<>();
        
        for(int i = 0; i < words[0].length(); ++i){
            char ch = words[0].charAt(i);
            finalMap.put(ch, finalMap.getOrDefault(ch, 0) + 1);
        } 
        
        for(int i = 1; i < words.length; ++i){
            HashMap<Character, Integer> tempMap = new HashMap<>();
            
            String word = words[i];
            for(char ch : word.toCharArray()) tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
            
            for(char ch : finalMap.keySet()){
                if(tempMap.containsKey(ch) == false) finalMap.put(ch, 0);
                else finalMap.put(ch, Math.min(finalMap.get(ch), tempMap.get(ch)));
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(char ch : finalMap.keySet()){
            while(finalMap.get(ch) > 0){
                res.add(Character.toString(ch));
                finalMap.put(ch, finalMap.get(ch) - 1);
            }
        }
        
        return res;
        
    }
}