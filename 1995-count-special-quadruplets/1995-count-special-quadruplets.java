class Solution {
    public int countQuadruplets(int[] nums) {
        // Arrays.sort(nums);
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(); 
        int n = nums.length;
        int res = 0;
        
        for(int i1 = 0; i1 < n-3; ++i1){
            for(int i2 = i1+1; i2 < n-2; ++i2){
                int sum = nums[i1] + nums[i2];
                List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
                map.put(sum, list);
                list.add(i2);
            }
        }
        
        for (int i4 = nums.length - 1; i4 > 2; i4--){
            for (int i3 = i4 - 1; i3 > 1; i3--){
                int sum = nums[i4] - nums[i3];
                if (map.containsKey(sum)) {
                    List<Integer> list = map.get(sum);
                    for (int i2 : list) if (i2 < i3) res++;
                }
            }
        }
        return res;
    }
}