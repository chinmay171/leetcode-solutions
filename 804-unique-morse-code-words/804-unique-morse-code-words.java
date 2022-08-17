class Solution {
    String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        // HashMap<Character, String> map = new HashMap<>();//create hashmap 
        // int idx = 0;
        // for(char c = 'a'; c <= 'z'; c++){
        //     map.put(c, morseCode[idx++]);
        // }
        
        HashMap<String, Integer> res = new HashMap<>();
        
        for(String word : words){
            String transformation = "";
            for(int i = 0; i < word.length(); ++i){
                transformation = transformation + morseCode[(word.charAt(i))-'a'];
            }
            
            if(res.containsKey(transformation) == false){
                res.put(transformation, 1);
            }
        }
        
        return res.size();
    }
}