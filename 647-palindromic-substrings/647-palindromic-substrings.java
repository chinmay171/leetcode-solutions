class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1)return 1;
        
        int count = 0; 
        
        for(int i = 0; i < s.length(); ++i){
            count++;
            
            //get odd length of palindromes
            int left1 = i - 1;
            int right1 = i + 1;
            while(left1 >= 0 && right1 < s.length()){
                if(s.charAt(left1) == s.charAt(right1)){
                    count++;
                    left1--;
                    right1++;
                }else{
                    break;
                }
            }
            
            //get even length of palindromes
            int left2 = i;
            int right2 = i+1;
            
            while(left2 >= 0 && right2 < s.length()){
                if(s.charAt(left2) == s.charAt(right2)){
                    count++;
                    left2--;
                    right2++;
                }else{
                    break;
                }
            }
        }
        
        return count;
    }
}