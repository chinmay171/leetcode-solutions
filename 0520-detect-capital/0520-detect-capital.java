class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        
        boolean isCaps = false;
        if(word.charAt(n-1) <= 90) isCaps = true;
        // System.out.println(isCaps);
        
        if(isCaps == true){
            for(int i = n-2; i >= 0; --i){
                if(word.charAt(i) >= 97) return false;
            }
        }else{
            for(int i = n-2; i >= 1; --i){
                if(word.charAt(i) <= 90) return false;
            }
        }
        
        return true;
    }
}