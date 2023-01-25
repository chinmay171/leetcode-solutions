class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    
    public void helper(String input, int idx, String output){
        if(idx == input.length()){
            res.add(output);
            return;
        }
        
        int curr = input.charAt(idx) - '0';
        for(char ch : map[curr].toCharArray()){
            helper(input, idx+1, output + ch);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        helper(digits, 0, "");
        return res;
    }
}