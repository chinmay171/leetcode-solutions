class Solution {
    List<String> ans = new ArrayList<>();
    
    public void recursion(int input, int open, int close, String output){
        if(open+close == input*2){
            ans.add(output);
            return;
        }
        
        if(open < input){
            recursion(input, open+1, close, output + '(');
        }
        if(close < open){
            recursion(input, open, close+1, output + ')');
        }
    }
    
    public List<String> generateParenthesis(int n) {
        recursion(n, 0, 0, "");
        return ans;
    }
}