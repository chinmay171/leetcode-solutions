class Solution {
    public int minAddToMakeValid(String s) {
        ArrayList<Character> stk = new ArrayList<>();
        
        char[] chs = s.toCharArray();
        for(char ch : chs){
            if(stk.size() > 0 && stk.get(stk.size() - 1) != ch && ch != '('){
                stk.remove(stk.size() - 1);
                continue;
            }
            stk.add(ch);
        }
        return stk.size();
    }
}