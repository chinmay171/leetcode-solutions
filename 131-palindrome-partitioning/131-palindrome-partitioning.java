class Solution {
    List<List<String>> res;
    
    public boolean isPallindrome(String str){
        int l = 0;
        int r = str.length() - 1;
        
        while(l <= r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    public void helper(String str, int i, List<String> partitions){
        
        if(i == str.length()){
            res.add(new ArrayList<>(partitions));
            return;
        }
        
        for(int j = i; j < str.length(); ++j){
            String left = str.substring(i, j + 1);
            if(isPallindrome(left) == true){
                partitions.add(left);
                helper(str, j+1, partitions);
                partitions.remove(partitions.size() - 1);
            }
        }
        
    }
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        helper(s, 0, partition);
        return res;
    }
}