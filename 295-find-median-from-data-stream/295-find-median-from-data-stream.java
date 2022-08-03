class MedianFinder {
    PriorityQueue<Integer> left, right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        double median = findMedian();
        if(num > median){
            right.add(num);
        }else{
            left.add(num);
        }
        
        if(left.size() > right.size() + 1){
            right.add(left.remove());
        }else if(right.size() > left.size() + 1){
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(left.size() + right.size() == 0)return -1;
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }else if(left.size() == right.size() + 1){
            return left.peek();
        }else{
            return right.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */