class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int r = n / 4;
        
        int[] map1 = new int[26];
        for(char ch : s.toCharArray()){
            map1[ch - 'A']++;
        }
        
        int req = 0;
        for(char ch : "QWER".toCharArray()){
            if(map1[ch - 'A'] > r){
                map1[ch - 'A'] -= r;
                req += map1[ch - 'A'];
            }else{
                map1[ch - 'A'] = 0;
            }
        }
        
        if(req == 0) return 0;
        
        int ans = 0;
        int[] map2 = new int[26];
        int count = 0;
        int j = -1;
        for(int i = 0; i < s.length(); ++i){
            char ch1 = s.charAt(i);
            map2[ch1 - 'A']++;
            if(map2[ch1 - 'A'] <= map1[ch1 - 'A']){
                count++;
            }
            
            while(j < i && count == req){
                if(ans == 0){
                    ans = i - j;
                }else{
                    ans = Math.min(ans, i - j);
                }
                
                j++;
                char ch2 = s.charAt(j);
                map2[ch2 - 'A']--;
                if(map2[ch2 - 'A'] < map1[ch2 - 'A']){
                    count--;
                }
            }
        }
        
        
        return ans;
        
    }
}