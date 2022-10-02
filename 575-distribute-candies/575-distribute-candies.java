class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int candy : candyType){
            hm.put(candy, hm.getOrDefault(candy, 0) + 1);
        }
        
        int n = candyType.length;
        
        if(hm.size() > n/2){
            return n/2;
        }
        return hm.size();
    }
}