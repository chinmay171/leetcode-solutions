class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> freq1 = new HashMap<>();
        HashMap<String, Integer> freq2 = new HashMap<>();
        
        String st1 = "";
        for(char ch : s1.toCharArray()){
            if(ch == ' '){
                freq1.put(st1, freq1.getOrDefault(st1, 0) + 1);
                st1 = "";
            }else st1 = st1 + ch;
        }
        if(st1 != "") freq1.put(st1, freq1.getOrDefault(st1, 0) + 1);
        
        String st2 = "";
        for(char ch : s2.toCharArray()){
            if(ch == ' '){
                freq2.put(st2, freq2.getOrDefault(st2, 0) + 1);
                st2 = "";
            }else st2 = st2 + ch;
        }
        if(st2 != "") freq2.put(st2, freq2.getOrDefault(st2, 0) + 1);
        
        ArrayList<String> res = new ArrayList<>();
        for(String str1 : freq1.keySet()){
            if(freq1.get(str1) == 1 && freq2.containsKey(str1) == false) res.add(str1);
        }
        
        for(String str2 : freq2.keySet()){
            if(freq2.get(str2) == 1 && freq1.containsKey(str2) == false) res.add(str2);
        }
        
        int n = res.size();
        String[] ans = new String[n];
        
        for(int i = 0; i < n; ++i) ans[i] = res.get(i);
        
        return ans;
    }
}