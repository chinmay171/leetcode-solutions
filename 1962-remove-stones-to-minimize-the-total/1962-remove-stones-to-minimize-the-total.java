class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < piles.length; ++i){
            pq.add(piles[i]);
        }
        
        while(k > 0){
            int front = pq.remove();
            int updated = 0;
            if(front%2 == 0){
                updated = front/2;
            }else{
                updated = front/2 + 1;
            }
            k--;
            
            pq.add(updated);
        }
        
        int sum = 0;
        while(pq.size() > 0){
            sum += pq.remove();
        }
        return sum;
    }
}