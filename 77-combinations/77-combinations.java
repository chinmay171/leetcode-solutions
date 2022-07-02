class Solution {
    public void combine(List<List<Integer>> combinations, List<Integer> combination, int currBox, int n, int k){
        if(currBox == n){
            if(combination.size() == k){
                List<Integer> temp = new ArrayList<>(combination);
                combinations.add(temp);
            }
            return;
        }
        
        //yes
        combination.add(currBox+1);
        combine(combinations, combination, currBox+1, n, k);
        combination.remove(combination.size()-1);
        //no
        combine(combinations, combination, currBox+1, n, k);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combine(combinations, combination, 0, n, k);
        return combinations;
    }
}