class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tasks.length; ++i){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        
        int rounds = 0;
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq < 2) return -1;
            else if(freq == 2 || freq == 3) rounds++;
            else{
                rounds += freq / 3;
                if(freq%3 != 0) rounds += 1;
            }
        }
        
        return rounds;
    }
}