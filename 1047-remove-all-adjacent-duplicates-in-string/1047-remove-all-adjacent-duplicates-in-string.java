class Solution {
    public void recursion(String input, int idx, StringBuilder output){
        if(idx >= input.length()) return;
        
        char ch = input.charAt(idx);
        if(output.length() > 0 && output.charAt(output.length()-1) == ch)
            output.deleteCharAt(output.length()-1);
        else output.append(ch);
        
        recursion(input, idx+1, output);
    }
    public String removeDuplicates(String s) {
        StringBuilder output = new StringBuilder();
        recursion(s, 0, output);
        return output.toString();
    }
}