class KthLargest {
    int kLargest;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        kLargest = k;
        pq = new PriorityQueue<>();

        for(int n : nums) pq.add(n);
        while(pq.size() > k) pq.remove();
    }
    
    public int add(int val) {
        if(pq.size() == 0 || pq.size() < kLargest){
            pq.add(val);
            return pq.peek();
        }
        if(val >= pq.peek()){
            pq.add(val);
            while(pq.size() > kLargest) pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */