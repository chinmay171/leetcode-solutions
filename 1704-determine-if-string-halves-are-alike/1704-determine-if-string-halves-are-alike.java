class Solution {

    public boolean halvesAreAlike(String s) {
        
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        
        int i = 0;
        int j = s.length()-1;
        
        int countRight = 0;
        int countLeft = 0;
        while(i < j){
            if(vowels.contains(s.charAt(i)) == true) countLeft++;
            if(vowels.contains(s.charAt(j)) == true) countRight++;
            i++;
            j--;
        }
        
        if(countLeft == countRight) return true;
        return false;
    }
}