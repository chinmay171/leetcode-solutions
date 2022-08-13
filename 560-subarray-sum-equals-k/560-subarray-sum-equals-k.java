class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0l, 1);
        Long sum = 0l;
        int count = 0;
        
        for(long val : nums){
            sum = sum + val;
            count = count + hm.getOrDefault(sum-k, 0);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}