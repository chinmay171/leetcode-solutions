class Solution {
    List<List<Integer>> res;
    int[] nums;
    
    public void permutation(int currBox, boolean[] itemPlaced, List<Integer> boxes){
        if(currBox == nums.length){
            List<Integer> temp = new ArrayList<>(boxes);
            res.add(temp);
            return;
        }
        
        for(int i = 0; i<nums.length;++i){
            if(itemPlaced[i] == false){
                itemPlaced[i] = true;
                boxes.add(nums[i]);
                permutation(currBox+1, itemPlaced, boxes);
                boxes.remove(boxes.size()-1);
                itemPlaced[i] = false;
            }
        }
    }
        
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        permutation(0, new boolean[nums.length], new ArrayList<>());
        return res;
    }
}