class Solution {
    public int getFreq(int[] nums, int target){
        int count = 0;
        for(int val : nums){
            if(val == target) count++;
        }
        return count;
    }
    public List<Integer> majorityElement(int[] nums) {
        int majority1 = Integer.MAX_VALUE, majority2 = Integer.MAX_VALUE;
        int freq1 = 0;
        int freq2 = 0;
        for(int val : nums){
            if(majority1 == val) freq1++;
            else if(majority2 == val) freq2++;
            else{
                if(freq1 == 0){
                    majority1 = val;
                    freq1 = 1;
                }else if(freq2 == 0){
                    majority2 = val;
                    freq2 = 1;
                }else{
                    freq1--;
                    freq2--;
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        if(getFreq(nums, majority1) > nums.length/3) res.add(majority1);
        if(getFreq(nums, majority2) > nums.length/3) res.add(majority2);
        return res;
    }
}