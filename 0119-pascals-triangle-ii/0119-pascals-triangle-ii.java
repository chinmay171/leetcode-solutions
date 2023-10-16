class Solution {
    public List<Integer> getRow(int rows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(new ArrayList<>());
        pascal.get(0).add(1);

        for(int i = 1; i <= rows; ++i){
            List<Integer> curr = new ArrayList<>();

            curr.add(1);
            for(int j = 1; j < i; ++j){
                int nck = pascal.get(i-1).get(j) + pascal.get(i-1).get(j-1);
                curr.add(nck);
            }
            curr.add(1);
            pascal.add(curr);
        }

        return pascal.get(rows);
    }
}