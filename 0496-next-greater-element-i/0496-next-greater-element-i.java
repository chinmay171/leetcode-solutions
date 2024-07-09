class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = nums2.length-1; i >= 0; i--){
            while(stk.size() > 0 && stk.peek() < nums2[i]){
                stk.pop();
            }
            if(stk.size() == 0) map.put(nums2[i], -1);
            else map.put(nums2[i], stk.peek());

            stk.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; ++i){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}