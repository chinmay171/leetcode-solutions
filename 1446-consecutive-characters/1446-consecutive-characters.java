class Solution {
    public int maxPower(String s) {
        int maxLen = 1;
        int currLen = 1;
        
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i-1) == s.charAt(i)){
                currLen++;
            }else{
                currLen = 1;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
        
    }
}