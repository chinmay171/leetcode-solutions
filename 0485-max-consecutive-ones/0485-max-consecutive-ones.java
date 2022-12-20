class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         int max = 0;
//         for(int i = 0; i < nums.length; ++i){
//             if(nums[i] == 1){
//                 map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//                 if(map.get(nums[i]) > max){
//                     max = map.get(nums[i]);
//                 }
//             }else{
//                 map.put(1, 0);
//             }
//         }
        
//         return max;
        int max = 0;
        for(int i = 0; i < nums.length; ++i){
            int curr = 0;
            while(i < nums.length && nums[i] == 1){
                curr++;
                i++;
                max = Math.max(max, curr);
            }
            
        }
        return max;
        
    }
}