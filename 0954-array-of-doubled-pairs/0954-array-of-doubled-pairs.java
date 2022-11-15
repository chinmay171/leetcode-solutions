class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for(int key : map.keySet()){
            if(map.get(key) == 0) continue;
            int req = 0;
            
            if(key < 0){
                if(key % 2 != 0){
                    return false;
                }else{
                    req = key / 2;
                }
            }else{
                req = key * 2;
            }
            
            if(map.getOrDefault(req, 0) < map.get(key)){
                return false;
            }else{
                map.put(req, map.get(req) - map.get(key));
            }
            
        }
        
        return true;
        
    }
}