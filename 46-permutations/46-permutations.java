class Solution {
    List<List<Integer>> res;
    int[] nums;
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void permutation(int currBox, List<Integer> boxes){
        if(currBox == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i<nums.length;++i){
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }
        
        for(int i = currBox; i<nums.length;++i){
            // if(itemPlaced[i] == false){
            //     itemPlaced[i] = true;
                // boxes.add(nums[i]);
                swap(nums, currBox, i);
                permutation(currBox+1, boxes);
                // boxes.remove(boxes.size()-1);
                swap(nums, currBox,i);
            //     itemPlaced[i] = false;
            // }
        }
    }
        
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        permutation(0, new ArrayList<>());
        return res;
    }
}