class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int val : nums){
            if(set.contains(val) == true){
                return true;
            }
            set.add(val);
        }
        
        return false;
    }
}