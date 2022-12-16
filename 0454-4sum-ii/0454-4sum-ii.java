class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        
        for(int i = 0; i < nums1.length; ++i){
            for(int j = 0; j < nums2.length; ++j){
                if(map.containsKey(nums1[i] + nums2[j]) == true){
                    ArrayList<ArrayList<Integer>> curr = map.get(nums1[i] + nums2[j]);
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums1[i]);
                    temp.add(nums2[j]);
                    // boolean flag = false;
                    // for(ArrayList<Integer> t : curr){
                    //     if(t.equals(temp) == true){
                    //         flag = true;
                    //         break;
                    //     }
                    // }
                    // if(flag == false){
                        curr.add(temp);
                        map.put(nums1[i]+nums2[j], curr);
                    // }
                }else{
                    ArrayList<ArrayList<Integer>> curr = new ArrayList<>();
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums1[i]);
                    temp.add(nums2[j]);
                    curr.add(temp);
                    map.put(nums1[i]+nums2[j], curr);
                }
            }
        }
        
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map1 = new HashMap<>();
        
        for(int i = 0; i < nums3.length; ++i){
            for(int j = 0; j < nums4.length; ++j){
                if(map1.containsKey(nums3[i] + nums4[j]) == true){
                    ArrayList<ArrayList<Integer>> curr = map1.get(nums3[i] + nums4[j]);
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums3[i]);
                    temp.add(nums4[j]);
                    // boolean flag = false;
                    // for(ArrayList<Integer> t : curr){
                    //     if(t.equals(temp) == true){
                    //         flag = true;
                    //         break;
                    //     }
                    // }
                    // if(flag == false){
                        curr.add(temp);
                        map1.put(nums3[i]+nums4[j], curr);
                    // }
                }else{
                    ArrayList<ArrayList<Integer>> curr = new ArrayList<>();
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums3[i]);
                    temp.add(nums4[j]);
                    curr.add(temp);
                    map1.put(nums3[i]+nums4[j], curr);
                }
            }
        }
        
        int count = 0;
        for(Integer a : map.keySet()){
            if(map1.containsKey(0 - a) == true){
                count = count + (map.get(a).size() * map1.get(0 - a).size());
            }
        }
        return count;
        
        // for(Integer a : map.keySet()){
        //     for(ArrayList<Integer> arr: map.get(a)){
        //         System.out.println(a + " -> " + arr);
        //     }
        // }
        // System.out.println("=========================");
        // for(Integer a : map1.keySet()){
        //     for(ArrayList<Integer> arr: map1.get(a)){
        //         System.out.println(a + " -> " + arr);
        //     }
        // }
        // return 1;
        
    }
}