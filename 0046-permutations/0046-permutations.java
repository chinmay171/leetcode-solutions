class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void recursion(int[] nums, List<Integer> output){
        if(output.size() == nums.length){
            res.add(new ArrayList<>(output));
            return;
        }
        
        for(int val : nums){
            if(output.contains(val) == true) continue;
            output.add(val);
            recursion(nums, output);
            output.remove(output.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        recursion(nums, new ArrayList<>());
        return res;
    }
}