class Solution {
    public int addDigits(int num) {
         String numStr = num + "";
        
        while(numStr.length() != 1){
            int curr = 0;
            for(int i = 0; i < numStr.length(); ++i){
                int c = numStr.charAt(i) - '0';
                curr += c;
            }
            num = curr;
            numStr = num + "";
        }
        return num;
    }
}