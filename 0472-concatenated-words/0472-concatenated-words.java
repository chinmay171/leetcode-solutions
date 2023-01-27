class Solution {
    int count = 0;
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<String> outputL = new ArrayList<>();

        if(words == null || words.length == 0)
        {
                    return outputL;
         }
               
        Set<String> unique =new HashSet<>();
        for(String s : words)
            unique.add(s);
        for(String word : words){
                
            if(concated(word, unique, 0, count))
                  outputL.add(word);
            
            count = 0;
         
        }
     
        return outputL;
    }
    
    
    boolean concated(String word, Set<String> unique, int start, int count){
        for(int i = start + 1 ; i <= word.length(); i++){
                String current = word.substring(start, i);
                if(unique.contains(current) && current.length() != word.length()){
                    count = i;
                    if(count == word.length()){
                         return true;
                    }else if(concated(word, unique, i, i))
                        return true;               
                }        
        }
        
    return false;
}
}