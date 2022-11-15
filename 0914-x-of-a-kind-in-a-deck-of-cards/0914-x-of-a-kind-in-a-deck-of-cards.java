class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        if(deck.length < 2)return false;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : deck){
            if(map.containsKey(num) == false){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        
        int ans = 0;
        for(int card : map.keySet()){
            ans = gcd(ans, map.get(card));
        }
        
        return ans > 1;
    }
    
    public int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        return gcd(b, a%b);
    }
}