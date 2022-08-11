class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        for(int i = 0; i < nums.length; ++i){
            int val = nums[i] % (n+1);
            nums[val-1] += n+1;
        }
        
        List<Integer> missing = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] < n+1)
                missing.add(i+1);
        }
        return missing;
    }
}