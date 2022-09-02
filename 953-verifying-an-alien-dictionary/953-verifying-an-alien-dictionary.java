class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        int priorityNo = 0;
        
        for(int i = 0; i < order.length(); ++i){
            map[order.charAt(i) - 'a'] = priorityNo++;
        }
        
        for(int i = 0; i < words.length-1; ++i){
            String first = words[i];
            String second = words[i+1];
            
            int minLen = Math.min(first.length(), second.length());
            boolean equal = true;
            for(int j = 0; j < minLen; ++j){
                int priorityOfFirst = map[first.charAt(j)-'a'];
                int priorityOfSecond = map[second.charAt(j) - 'a'];
                    
                // System.out.println("first "+j+" > "+priorityOfFirst);
                // System.out.println("second "+j+" > "+priorityOfSecond);
                if(priorityOfFirst < priorityOfSecond){
                    equal = false;
                    break;
                }else if(priorityOfFirst > priorityOfSecond){
                    return false;
                }else continue;
            }
            if(equal && first.length() > second.length()) return false;
        }
        
        return true;
    }
}