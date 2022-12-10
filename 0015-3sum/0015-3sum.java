class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length-1; ++i){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int j = i+1;
            int k = nums.length - 1;

            int tempk = 0 - nums[i];
            int x = j;
            while(j < k){
                if(j > x && nums[j-1] == nums[j]){
                    j++; continue;
                } 
                if(nums[j] + nums[k] == tempk){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                }else if(nums[j] + nums[k] < tempk) j++;
                 else k--;
            }
        }
        
        return res;
    }
}