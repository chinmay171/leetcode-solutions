class Solution {
    public int minFlipsMonoIncr(String s) {
        int minimumFlips = 0;
        int countOfOnes = 0;
        
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '1'){
                countOfOnes++;
            }else{
                minimumFlips = Math.min(countOfOnes, minimumFlips + 1);
            }
        }
        
        return minimumFlips;
    }
}