class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int res = 0;
        
        HashSet<Character> set = new HashSet<>();
        int j = -1;
        
        for(int i = 0; i < s.length(); ++i){
            char c1 = s.charAt(i);
            
            if(set.contains(c1)){
                //release
                while(j < i){
                    j++;
                    char c2 = s.charAt(j);
                    set.remove(c2);
                    if(c1 == c2){
                        break;
                    }
                }
            }
            
            //acquire
            set.add(c1);
            res = Math.max(res, set.size());
        }
        
        return res;
        
    }
}