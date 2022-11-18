class Solution {
    public int numberOfSubstrings(String s) {
        return atmostK(s, 3) - atmostK(s, 2);
    }
    
    public int atmostK(String nums, int k){
        int res = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int j = -1;
        
        for(int i = 0; i < nums.length(); ++i){
            map.put(nums.charAt(i), map.getOrDefault(nums.charAt(i), 0) + 1);
            
            while(j < i && map.size() > k){
                j++;
                
                map.put(nums.charAt(j), map.getOrDefault(nums.charAt(j), 0) - 1);
                if(map.get(nums.charAt(j)) == 0){
                    map.remove(nums.charAt(j));
                }
            }
            
            res += (i - j);
        }
        
        return res;
    }
}