class Solution {
    public void memo(List<List<Integer>> res, int n){
        if(n == 1){
            res.add(Arrays.asList(1));
        }else if( n > 1){
            memo(res, n-1);
            
            List<Integer> currList = new ArrayList<>();
            List<Integer> prevList = res.get(n-2);
            
            for(int i = 0; i<prevList.size(); ++i){
                if(i == 0)currList.add(1);
                if(i > 0)currList.add(prevList.get(i)+prevList.get(i-1));
                if(i == prevList.size()-1)currList.add(1);
            }
            res.add(currList);
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        memo(ans, numRows);
        return ans;
    }
}