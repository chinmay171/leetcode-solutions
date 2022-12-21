class Solution {
    public int helper(String nums, int k, char ch){
        int left = 0;
        int maxLen = 0;
        int replacement = 0;
        for(int right = 0; right < nums.length(); ++right){
            if(nums.charAt(right) != ch) replacement++;
            
            while(replacement > k){
                if(nums.charAt(left) != ch) replacement--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
    
    public int characterReplacement(String s, int k) {
        int ans = 0;
        for(int i = 0; i < 26; ++i){
            ans = Math.max(ans, helper(s, k, (char)(i+'A')));
        }
        
        return ans;
    }
}