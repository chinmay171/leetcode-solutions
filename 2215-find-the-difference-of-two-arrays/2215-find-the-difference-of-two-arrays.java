class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for(int num : nums1) set1.add(num);
        for(int num : nums2) set2.add(num);
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for(int num : set1){
            if(set2.contains(num) == false) first.add(num);
        }
        for(int num : set2){
            if(set1.contains(num) == false) second.add(num);
        }
        
        ans.add(first);
        ans.add(second);
        return ans;
    }
}