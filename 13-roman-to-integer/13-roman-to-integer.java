class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < 7; ++i){
            hm.put('I', 1);
            hm.put('V', 5);
            hm.put('X', 10);
            hm.put('L', 50);
            hm.put('C', 100);
            hm.put('D', 500);
            hm.put('M', 1000);
        }
        
        char lastCh = s.charAt(s.length()-1);
        int ans = hm.get(lastCh);
        
        for(int i = s.length()-2; i >= 0 ; --i){
            int lastVal = hm.get(s.charAt(i+1));
            
            int currVal = hm.get(s.charAt(i));
            
            if(currVal < lastVal){
                ans = ans - currVal;
            }else{
                ans = ans + currVal;
            }
        }
        
        return ans;
    }
}