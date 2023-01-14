class Solution {
    int[] leader = new int[26];
    
    private void union(int x, int y){
        int leaderX = findLeader(x);
        int leaderY = findLeader(y);
        
        if(leaderX == leaderY){
            return;
        }else if(leaderX < leaderY){
            leader[leaderY] = leaderX;
        }else{
            leader[leaderX] = leaderY;
        }
    }
    
    private int findLeader(int x){
        if(x == leader[x]){
            return x;
        }
        return leader[x] = findLeader(leader[x]);
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i = 0; i < 26; ++i){
            leader[i] = i;
        }
        
        for(int i = 0; i < s1.length(); ++i){
            union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }
        
        String result = "";
        for(int i = 0; i < baseStr.length(); ++i){
            result += (char)(findLeader(baseStr.charAt(i) - 'a') + 'a');
        }
        
        return result;
    }
}