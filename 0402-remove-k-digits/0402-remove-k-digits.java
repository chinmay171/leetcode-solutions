class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder str = new StringBuilder();
        
        char[] numChar = num.toCharArray();
        
        for(char ch : numChar){
            while(k > 0 && str.length() > 0 && str.charAt(str.length()-1) > ch){
                str.deleteCharAt(str.length() - 1);
                k--;
            }
            str.append(ch);
        }
        
        while(k-- > 0){
            str.deleteCharAt(str.length() - 1);
        }
        
        int idx = 0;
        while(idx < str.length() && str.charAt(idx) == '0'){
            idx++;
        }
        
        if(idx == str.length()) return "0";
        return str.toString().substring(idx);
    }
}