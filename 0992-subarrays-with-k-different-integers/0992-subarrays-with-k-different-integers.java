class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums, k) - atmostK(nums, k-1);
    }
    
    public int atmostK(int[] nums, int k){
        int res = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = -1;
        
        for(int i = 0; i < nums.length; ++i){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            while(j < i && map.size() > k){
                j++;
                
                map.put(nums[j], map.getOrDefault(nums[j], 0) - 1);
                if(map.get(nums[j]) == 0){
                    map.remove(nums[j]);
                }
            }
            
            res += (i - j);
        }
        
        return res;
    }
}