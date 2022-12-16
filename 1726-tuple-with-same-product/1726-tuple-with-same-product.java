class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        
        int count = 0;
        for(Integer i : map.keySet()){
            int val = map.get(i);
            count = count + val * (val - 1) / 2;
        }
        
        return 8 * count;
    }
}