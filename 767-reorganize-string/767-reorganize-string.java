class Solution {
    public static class pair{
        char ch;
        int freq;
        
        pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    public static class freqComp implements Comparator<pair>{
        public int compare(pair a, pair b){
            if(a.freq == b.freq)return (a.ch - b.ch);
            return (b.freq - a.freq);
        }
    }
    
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i<s.length(); ++i){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<pair> q = new PriorityQueue<>(new freqComp());
        
        for(Character ch : freq.keySet()){
            q.add(new pair(ch, freq.get(ch)));
        }
        
        StringBuilder str = new StringBuilder("");
        while(q.size() > 0){
            pair odd = q.remove();
            str.append(odd.ch);
            odd.freq--;
            
            if(q.size() == 0 && odd.freq > 0)return "";
            
            if(q.size() > 0){
                pair even = q.remove();
                str.append(even.ch);
                even.freq--;
                
                if(even.freq > 0){
                    q.add(even);
                }
            }
            
            if(odd.freq > 0){
                q.add(odd);
            }
        }
        
        return str.toString();
    }
}