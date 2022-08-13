class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //<last occurance, value of nums array>
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(nums[i]) == true){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }else{
                    map.put(nums[i], i);
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}