class Solution {
    List<List<Integer>> res;
    
    public void permuteUnique(HashMap<Integer, Integer> freq, int[] nums, int currBox, List<Integer> ans){
        
        if(currBox == nums.length){
            List<Integer> temp = new ArrayList<>(ans);
            res.add(temp);
            return;
        }
        
        for(Integer key : freq.keySet()){
            int val = freq.get(key);
            if(val > 0){
                freq.put(key, val-1);
                ans.add(key);
                
                permuteUnique(freq, nums, currBox+1, ans);
                
                ans.remove(ans.size()-1);
                freq.put(key, val);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i<nums.length; ++i){
            if(freq.containsKey(nums[i])){
                int val = freq.get(nums[i]);
                freq.put(nums[i], val+1);
            }else{
                freq.put(nums[i], 1);
            }
        }
        this.res = new ArrayList<>();
        permuteUnique(freq, nums, 0, new ArrayList<>());
        return res;
    }
}