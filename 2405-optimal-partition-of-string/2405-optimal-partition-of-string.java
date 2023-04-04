class Solution {
    // hdklqkcssgxlvehva
    // <a,b><a,c><a,b>
    public int partitionString(String s) {
        int ans = 0;
        
        for(int i = 0; i < s.length(); ){
            HashSet<Character> set = new HashSet<>();
            while(i < s.length() && set.contains(s.charAt(i)) == false){
                set.add(s.charAt(i));
                i++;
            }
            // System.out.println(set);
            ans++;
        }
        return ans;
    }
}