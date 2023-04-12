class Solution {
    public String simplifyPath(String path) {
        String[] chArr = path.split("/");
        Stack<String> stk = new Stack<>();
        
        for(int i = 0; i < chArr.length; ++i){
            if(chArr[i].equals("")) continue;
            if(chArr[i].equals(".")) continue;
            if(stk.size() == 0 && chArr[i].equals("..")) continue;
            if(stk.size() > 0 && chArr[i].equals("..")) stk.pop();
            else stk.push(chArr[i]);
        }
        String ans = "";
        while(stk.size() > 0){
            ans = "/" + stk.pop() + ans;
        }
        return (ans.equals("")) ? "/" : ans;
    }
}