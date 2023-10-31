class Solution {
    public int[] findArray(int[] pref) {
        int x = 0;

        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        for(int i = 1; i < pref.length; ++i){
            x = pref[i] ^ pref[i-1];
            ans[i] = x;
        }

        return ans;
    }
}