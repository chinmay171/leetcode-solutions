class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        
        int[] lps = new int[n];
        
        int i = 0, j = 1;
        while(j < n){
            if(s.charAt(i) == s.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0)j++;
                else i = lps[i-1];
            }
        }
        return s.substring(0, lps[n-1]);
    }
}