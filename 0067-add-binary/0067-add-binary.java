class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        String ans = "";
        boolean carry = false;
        while(i >= 0 && j >= 0){
            if(a.charAt(i) == '1' && b.charAt(j) == '1' && carry == true){
                ans = ans + "1";
            }else if(a.charAt(i) == '1' && b.charAt(j) == '1'){
                ans = ans + "0";
                carry = true;
            }else if((a.charAt(i) == '1' || b.charAt(j) == '1') && carry == true){
                ans = ans + "0";
            }else if((a.charAt(i) == '1' || b.charAt(j) == '1') && carry == false){
                ans = ans + "1";
            }else if((a.charAt(i) == '0' && b.charAt(j) == '0') && carry == true){
                ans = ans + "1";
                carry = false;
            }else{
                ans = ans + "0";
            }
            i--;
            j--;
        }
        while(i >= 0){
            if(carry == true && a.charAt(i) == '1'){
                ans = ans + "0";
            }else if(carry == true && a.charAt(i) == '0'){
                ans = ans + "1";
                carry = false;
            }else{
                ans = ans + a.charAt(i);
            }
            i--;
        }
        while(j >= 0){
            if(carry == true && b.charAt(j) == '1'){
                ans = ans + "0";
            }else if(carry == true && b.charAt(j) == '0'){
                ans = ans + "1";
                carry = false;
            }else{
                ans = ans + b.charAt(j);
            }
            j--;
        }
        if(carry == true){
            ans = ans + "1";
        }
        StringBuilder input1 = new StringBuilder();
        input1.append(ans);
        return input1.reverse().toString();
    }
}