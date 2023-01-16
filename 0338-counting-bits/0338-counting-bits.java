class Solution {
    public int[] countBits(int n) {
        // approach 1 only bitmasking
        int[] ans = new int[n+1];
        // for(int i = 0; i <= n; ++i){
        //     ans[i] = Integer.bitCount(i);
        // }
        // return ans;
        
        // approach 2 DP with bitmasking
        for(int i = 1; i <= n; ++i){
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}