class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ans : answers){
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        
        int res = 0;
        
        for(int key : map.keySet()){
            int gs = key + 1;
            int count = map.get(key);
            
            int ciel = (count + gs -1) / gs;
            
            int rabbits = ciel * gs;
            res += rabbits;
        }
        
        return res;
    }
}