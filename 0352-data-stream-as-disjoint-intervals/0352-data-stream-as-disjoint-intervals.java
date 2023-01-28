class SummaryRanges {
    TreeSet<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }
    // [1, 3, 7,]
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        ArrayList<int[]> intervals = new ArrayList<>();
        
        for(int val : set){
            int size = intervals.size();
            
            if(size > 0 && intervals.get(size-1)[1] + 1 == val){
                intervals.get(size-1)[1] = val;
            }else{
                intervals.add(new int[]{val, val});
            }
        }
        
        int n = intervals.size();
        int[][] arrIntervals = new int[n][2];
        for(int i = 0; i < n; ++i){
            int[] t = intervals.get(i);
            arrIntervals[i][0] = t[0];
            arrIntervals[i][1] = t[1];
        }
        
        return arrIntervals;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */