class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public void helper(int[] nums, int idx, List<Integer> subset){
        if(idx == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[idx]);
        helper(nums, idx+1, subset);
        subset.remove(subset.size()-1);
        
        if(subset.size() > 0 && subset.get(subset.size()-1) == nums[idx])
            return;
        helper(nums, idx+1, subset);
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }
}