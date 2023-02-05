class Solution {
    List<List<Integer>> subsets = new ArrayList<>();
    
    public void helper(int[] nums, int idx, int target, List<Integer> subset){
        if(idx == nums.length){
            if(target == 0) 
                subsets.add(new ArrayList<>(subset));
            return;
        }
        
        if(target < 0) return;
        //yes 1
        subset.add(nums[idx]);
        helper(nums, idx, target - nums[idx], subset);
        subset.remove(subset.size()-1);
        
        //yes 2
        subset.add(nums[idx]);
        helper(nums, idx+1, target - nums[idx], subset);
        subset.remove(subset.size()-1);
        
        //no
        if(subset.size() > 0 && subset.get(subset.size()-1) == nums[idx])
            return;
        helper(nums, idx+1, target, subset);
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>());
        return subsets;
    }
}