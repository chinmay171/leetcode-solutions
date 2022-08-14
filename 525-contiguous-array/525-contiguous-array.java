class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, -1);
        
        int zeroes = 0, ones = 0, largest = 0;
        
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0)zeroes++;
            else ones++;
            
            if(freq.containsKey(zeroes - ones) == false){
                freq.put(zeroes - ones, i);
            }
            
            largest = Math.max(largest, i - freq.get(zeroes - ones));
        }
        
        return largest;
    }
}