class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public void recursion(int curr, int n){
        if(curr > n) return;
        if(curr <= n && curr > 0) ans.add(curr);
        
        for(int i = 0; i <= 9; ++i){
            if(curr == 0 && i == 0) continue;
            recursion(curr * 10 + i, n);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        recursion(0, n);
        return ans;
    }
}