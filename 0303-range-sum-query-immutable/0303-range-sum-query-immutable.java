class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length+1];
        
        prefix[0] = 0;
        for(int i = 0; i < nums.length; ++i){
            prefix[i+1] = prefix[i] + nums[i];
        }
        for(int i = 0; i < prefix.length; ++i){
            System.out.print(prefix[i] + " ");
        }
    }
    
    public int sumRange(int left, int right) {
        int l = prefix[left];
        int r = prefix[right+1];
        
        return r - l;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */