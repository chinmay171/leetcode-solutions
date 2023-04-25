class SmallestInfiniteSet {
    HashSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        int ans = 1;
        while(set.contains(ans) == true){
            ans++;
        }
        set.add(ans);
        return ans;
    }
    
    public void addBack(int num) {
        if(set.contains(num) == true) set.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */