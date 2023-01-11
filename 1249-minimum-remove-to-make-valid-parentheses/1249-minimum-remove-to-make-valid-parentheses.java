class Solution {
    public String minRemoveToMakeValid(String s) {
        
//         Stack<Integer> stk = new Stack<>();
        
//         ArrayList<Character> arr = new ArrayList<>();
//         char[] chs = s.toCharArray();
//         for(char ch : chs) arr.add(ch);
        
//         for(int i = 0; i < arr.size(); ++i){
//             if(arr.get(i) != ')' && arr.get(i) != '('){
//                 continue;
//             }
//             if(arr.get(i) == ')'){
//                 if(stk.size() == 0) arr.remove(i);
//                 else stk.pop();
//             }else stk.push(i);
//         }
        
//         while(stk.size() > 0){
//             arr.remove(stk.peek());
//             stk.pop();
//         }
//         String ans = "";
//         for(char ch : arr) ans += ch;
        
//         return ans;
        boolean[] isBalance = new boolean[s.length()];
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                isBalance[i] = true;
                stk.push(i);
            }else if(s.charAt(i) == ')'){
                if(stk.size() > 0){
                    isBalance[stk.pop()] = false;
                }else{
                    isBalance[i] = true;
                }
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < s.length(); ++i){
            if(isBalance[i] == false){
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}