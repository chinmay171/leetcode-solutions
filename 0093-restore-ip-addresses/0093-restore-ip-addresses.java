class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, 0, "", ans);
        return ans;
    }
    
    public void helper(String s, int i, int par, String res, List<String> ans){
        if(i == s.length() || par == 4){
            if(i == s.length() && par == 4){
                ans.add(res.substring(0, res.length()-1));
            }
            return;
        }
        
        helper(s, i+1, par+1, res + s.charAt(i) + ".", ans);
        if(i+2 <= s.length() && isValid(s.substring(i, i+2)))
            helper(s, i+2, par+1, res + s.substring(i, i+2) + ".", ans);
        if(i+3 <= s.length() && isValid(s.substring(i, i+3)))
            helper(s, i+3, par+1, res + s.substring(i, i+3) + ".", ans); 
    }
    
    public boolean isValid(String s){
        if(s.charAt(0) == '0') return false;
        int temp = Integer.parseInt(s);
        if(temp <= 255 && temp >= 0) return true;
        return false;
    }
}