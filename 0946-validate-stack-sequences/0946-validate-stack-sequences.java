class Solution {
    //
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < popped.length; ++i){
            while(stk.size() == 0 || stk.peek() != popped[i]){
                if(j == pushed.length) return false;
                stk.push(pushed[j]);
                j++;
            }
            if(stk.peek() == popped[i]) stk.pop();
            else return false;
        }
        return true;
    }
}