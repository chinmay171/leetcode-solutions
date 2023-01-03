class Solution {
    public int minDeletionSize(String[] strs) {
        if(strs.length == 1) return 0;
        int n = strs.length;
        int strLen = strs[0].length();
        
        int ans = 0;
        
        for(int i=0; i < strLen; ++i){
            for(int j=0; j < n-1; ++j){
                char ch1 = strs[j].charAt(i);
                char ch2 = strs[j+1].charAt(i);
                if(ch2 < ch1){
                    ans++;
                    break;
                }
            }
        }
        
        return ans;
    }
}