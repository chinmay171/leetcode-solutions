class Solution {
    List<String> ans = new ArrayList<>();
    
    public void recursion(String input, int idx, String output){
        if(idx == input.length()){
            ans.add(output);
            return;
        }   
        
        char ch = input.charAt(idx);
            
        if(ch >= 48 && ch <= 57){
            recursion(input, idx+1, output + ch);
        }else{
            //to upper case
            recursion(input, idx+1, output + Character.toUpperCase(ch));
            //to lower case
            recursion(input, idx+1, output + Character.toLowerCase(ch));
        }
    }
    
    public List<String> letterCasePermutation(String s) {
        recursion(s, 0, "");
        return ans;
    }
}