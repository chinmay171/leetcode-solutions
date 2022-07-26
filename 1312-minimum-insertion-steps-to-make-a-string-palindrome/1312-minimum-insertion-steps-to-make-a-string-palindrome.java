class Solution {
    public int lcs(String text1, String text2){
        int[] next = new int[text2.length()+1];
        for(int i = text1.length()-1; i>=0; --i){
            
            int[] curr = new int[text2.length()+1];
            
            for(int j = text2.length()-1; j>=0; --j){
                
                if(text1.charAt(i) == text2.charAt(j)){
                    curr[j] = next[j+1] + 1;
                }else{
                    curr[j] = Math.max(next[j],curr[j+1]);
                }
            }
            next = curr;
        }
        return next[0];
    }
    public int minInsertions(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev = rev.reverse();
        String s2 = new String(rev);
        return s.length()-lcs(s, s2);
    }
}