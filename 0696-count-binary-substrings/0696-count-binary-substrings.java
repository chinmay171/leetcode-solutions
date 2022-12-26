class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int j = -1;
        int i = 0;
        while(i < n){
            int countZeroes = 0;
            int countOnes = 0;  
            if(s.charAt(i) == '0'){
                while(i < n && s.charAt(i) == '0'){
                    countZeroes++;
                    i++;
                }
                j = i;
                while(i < n && s.charAt(i) == '1'){
                    countOnes++;
                    i++;
                }
                ans += Math.min(countZeroes, countOnes);
                if(i == n) break;
                i = j;
            }else{
                while(i < n && s.charAt(i) == '1'){
                    countOnes++;
                    i++;
                }
                j = i;
                while(i < n && s.charAt(i) == '0'){
                    countZeroes++;
                    i++;
                }
                ans += Math.min(countZeroes, countOnes);
                if(i == n) break;
                i = j;
            }
        }
        
        return ans;
    }
}