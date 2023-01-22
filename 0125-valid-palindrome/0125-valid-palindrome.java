class Solution {
    public boolean isValid(String s, int left, int right){
        if(left >= right) return true;
        
        if(Character.isLetterOrDigit(s.charAt(left)) == false){
            return isValid(s, left+1, right);
        }
        if(Character.isLetterOrDigit(s.charAt(right)) == false){
            return isValid(s, left, right-1);
        }
        
        if(s.charAt(left) != s.charAt(right)){
            return false;
        }
        
        return isValid(s, left + 1, right - 1);
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        return isValid(s, 0, s.length()-1);
    }
}