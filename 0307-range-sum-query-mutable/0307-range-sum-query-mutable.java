class NumArray {
    
    int[] nodes;
    int n;
    
    public void construct(int[] nums, int idx, int left, int right){
        if(left > right) return;
        if(left == right){
            nodes[idx] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        construct(nums, 2*idx + 1, left, mid);
        construct(nums, 2*idx + 2, mid+1, right);
        nodes[idx] = nodes[2*idx + 1] + nodes[2*idx + 2];
    }
    
    public NumArray(int[] nums) {
        this.n = nums.length;
        nodes = new int[4*n + 5];
        construct(nums, 0, 0, n-1);
    }
    
    public void dfs2(int idx, int left, int right, int index, int val){
        if(left > right) return;
        if(left == right) {
            nodes[idx] = val;
            return;
        }

        int mid = left + (right - left) / 2;
        if(index <= mid) dfs2(2 * idx + 1, left, mid, index, val);
        else  dfs2(2 * idx + 2, mid + 1, right, index, val);
        nodes[idx] = nodes[2 * idx + 1] + nodes[2 * idx + 2];
    }
    
    public void update(int index, int val) {
        dfs2(0, 0, n-1, index, val);
    }
    
    public int dfs(int gl, int gr, int idx, int nl, int nr){
        if(gr < nl || gl > nr) return 0;
        if(gl <= nl && gr >= nr) return nodes[idx];
        
        int mid = (nl + nr) / 2;
        return dfs(gl, gr, 2*idx+1, nl, mid)
              +dfs(gl, gr, 2*idx+2, mid+1,nr);
    }
    
    public int sumRange(int left, int right) {
        return dfs(left, right, 0, 0, n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */