class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        
        int count = 0, pref = 0;
        for(int val : nums){
            pref = pref + val;
            int remainder = (pref % k + k)%k;
            count = count + freq.getOrDefault(remainder, 0);
            freq.put(remainder, freq.getOrDefault(remainder, 0)+1);
        }
        
        return count;
    }
}