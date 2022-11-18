class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < wall.size(); ++i){
            int breakage = 0;
            for(int j = 0; j < wall.get(i).size() - 1; ++j){
                breakage = wall.get(i).get(j) + breakage;
                map.put(breakage, map.getOrDefault(breakage, 0) + 1);
            }
        }
        
        int max = 0;
        for(int key : map.keySet()){
            max = Math.max(max, map.get(key));
        }
        
        return wall.size() - max;
    }
}