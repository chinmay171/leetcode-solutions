class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public void helper(int[] nums, int idx, int target, List<Integer> subset){
        if(idx == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(subset));
            }
            return;
        }
        
        //yes
        if(target < 0) return;
        subset.add(nums[idx]);
        helper(nums, idx+1, target - nums[idx], subset);
        subset.remove(subset.size()-1);
        
        //no
        if(subset.size() > 0 && subset.get(subset.size()-1) == nums[idx])
            return;
        helper(nums, idx+1, target, subset);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>());
        return ans;
    }
}