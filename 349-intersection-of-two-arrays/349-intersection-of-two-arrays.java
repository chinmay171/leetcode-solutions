class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i<nums1.length; ++i){
            hm.put(nums1[i], hm.getOrDefault(nums1[i], 0)+1);
        }
        
        ArrayList<Integer> intersection = new ArrayList<>();
        
        for(int j = 0; j<nums2.length; ++j){
            if(hm.containsKey(nums2[j]) == true){
                intersection.add(nums2[j]);
                hm.remove(nums2[j]);
            }
        }
        
        int[] res = new int[intersection.size()];
        for(int i = 0; i<res.length; ++i){
            res[i] = intersection.get(i);
        }
        return res;
    }
}