class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        
        for(int i = 0; i < operations.length; ++i){
            char ch = operations[i].charAt(1);
            if(ch == '-'){
                ans--;
            }else{
                ans++;
            }
        }
        
        return ans;
    }
}