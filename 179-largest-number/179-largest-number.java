class Solution {
    public String largestNumber(int[] nums) {
        String[] copy = new String[nums.length];
        boolean check = false;
        
        for(int  i = 0;  i < nums.length; ++i){
            if(nums[i] != 0) check = true;
            
            copy[i] = Integer.toString(nums[i]);
        }
        
        if(check == false) return "0";
        
        Arrays.sort(copy, (a, b) -> {
            if((a+b).compareTo(b+a) < 0) return +1;
            return -1;
        });
        
        StringBuilder res = new StringBuilder("");
        for(String val : copy) res.append(val);
        return res.toString();
    }
}