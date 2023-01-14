class Solution {
    public String convertToBase7(int num) {
        // StringBuilder res = new StringBuilder();
        
        long res = 0;
        int power = 1;
        while(num != 0){
            // char ch = (char)('0' + num % 7);
            // res.append(ch);
            int rem = num % 7;
            res = res + power*rem;
            num = num / 7;
            power *= 10;
        }
        
        return String.valueOf(res);
        // return res.reverse().toString();
    }
}