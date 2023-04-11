class Solution {
    public String removeStars(String s) {
        StringBuilder a = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) != '*') stk.push(s.charAt(i));
            else{
                stk.pop();
            }
        }
        
        while(stk.size() != 0){
            a.append(stk.pop());
        }
        
        return a.reverse().toString();
    }
}