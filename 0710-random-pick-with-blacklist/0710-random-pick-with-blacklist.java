class Solution {
    Random R;
    int range;
    HashMap<Integer, Integer> map;
    HashSet<Integer> invalid;

    public Solution(int n, int[] blacklist) {
        range = n - blacklist.length;
        R = new Random();
        
        map = new HashMap<>();
        invalid = new HashSet<>();
        
        for(int b : blacklist){
            invalid.add(b);
        }
        
        int curr = range;
        for(int b : blacklist){
            if(b < range){
                while(invalid.contains(curr)){
                    curr++;
                }
                map.put(b, curr);
                curr++;
            }
        }
        
    }
    
    public int pick() {
        int res = R.nextInt(range);
        
        if(map.containsKey(res) == true){
            res = map.get(res);
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */