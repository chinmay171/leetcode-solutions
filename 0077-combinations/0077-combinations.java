class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void recursion(int n, int k, List<Integer> output){
        if(k == 0){
            res.add(new ArrayList<>(output));
            return;
        }
        if(n == 0) return;
        
        for(int item = n; item >= 1; --item){
            output.add(item);
            recursion(item-1, k-1, output);
            output.remove(output.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        recursion(n, k, new ArrayList<>());
        return res;
    }
}