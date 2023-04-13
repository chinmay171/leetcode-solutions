class Solution { // 3 3
    // 1 1
    // 0 1  
    public String removeOuterParentheses(String s) {
        // Stack<Character> stk = new Stack<>();
        
        int open = 0;
        int close = 0;
        HashSet<Integer> set = new HashSet<>();
        if(s.charAt(0) == '(') set.add(0);
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(') open++;
            if(s.charAt(i) == ')') close++;
            if(open == close){
                set.add(i);
                if(i < s.length()-1 && s.charAt(i+1) == '(') set.add(i+1);
                open = close = 0;
            }
        }
        
        String ans = "";
        for(int i = 0; i < s.length(); ++i){
            if(set.contains(i) == false) ans = ans + s.charAt(i);
        }
        
        return ans;
    }
}