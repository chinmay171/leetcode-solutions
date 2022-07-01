class Solution {
    public List<List<Integer>> subsets(int[] nums, int idx){
        if(idx == nums.length){
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        List<List<Integer>> recSubsets = subsets(nums, idx+1);
        List<List<Integer>> res = new ArrayList<>();
        
        for(List<Integer> subSets : recSubsets){
            //If choice is To be added
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[idx]);
            for(int t : subSets){
                temp.add(t);
            }
            res.add(temp);
            //If choice is NOT to be added
            res.add(subSets);
        }
        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }
}