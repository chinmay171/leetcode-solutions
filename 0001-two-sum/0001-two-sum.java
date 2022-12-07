class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; ++i){
            if(hm.containsKey(target - nums[i]) == true){
                int[] ans = new int[2];
                ans[0] = hm.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            hm.put(nums[i], i);
        }
        
        return new int[1];
    }
}