class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String word : strs){
            
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String parent = new String(charArr);
            
            if(hm.containsKey(parent) == false){
                hm.put(parent, new ArrayList<>());
            } 
            
            hm.get(parent).add(word);
        }
        
        List<List<String>> r = new ArrayList<>();
        for(String key : hm.keySet()){
            r.add(hm.get(key));
        }
        return r;
    }
}