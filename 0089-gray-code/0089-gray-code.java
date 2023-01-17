class Solution {
    public List<Integer> grayCode(int n) {
        if(n == 1){
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(1);
            return ans;
        }
        
        List<Integer> ans = grayCode(--n);
        
        for(int i = ans.size()-1; i >= 0; --i){
            int res = (ans.get(i)) | (1 << n);
            ans.add(res);
        }
    
        return ans;                  
    }
}