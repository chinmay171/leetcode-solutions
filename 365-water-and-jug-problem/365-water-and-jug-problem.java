class Solution {
    public boolean canMeasureWater(int jug1, int jug2, int maxCap) {
        if(jug1 + jug2 < maxCap) return false;
        
        int[] operations = { +jug1, +jug2, -jug1, -jug2};
        HashMap<Integer, Integer> vis = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(q.size() > 0){
            int currWater = q.remove();
            
            if(vis.containsKey(currWater)) continue;
            vis.put(currWater, 1);
            
            for(int i = 0; i < 4; ++i){
                int tempWater = currWater + operations[i];
                
                if(tempWater == maxCap)return true;
                
                if(tempWater < 0 || tempWater > jug1 + jug2) continue;
                
                q.add(tempWater);
            }
        }
        return false;
    }
}