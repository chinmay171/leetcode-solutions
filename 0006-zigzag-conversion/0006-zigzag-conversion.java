class Solution {
    public String convert(String s, int numRows) {
        if(numRows > s.length()) return s;
        String[] model = new String[numRows];
        
        int i = 0;
        while(i < s.length()){
            for(int j = 0; j < numRows && i < s.length(); ++j){
                model[j] = model[j] + s.charAt(i);
                i++;
            }
            for(int j = numRows-2; j > 0 && i < s.length(); --j){
                model[j] = model[j] + s.charAt(i);
                i++;
            }
        }
        
        String ans = "";
        for(int x = 0; x < numRows; ++x){
            model[x] = model[x].substring(4, model[x].length());
            ans = ans + model[x];
        }
        return ans;
    }
}