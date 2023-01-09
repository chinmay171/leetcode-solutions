class Solution {
    class pair{
        int diff;
        int idx;
        
        pair(int diff, int idx){
            this.diff = diff;
            this.idx = idx;
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<pair> pq = new PriorityQueue<>((one, two)->
                                                    two.diff-one.diff);
        
        for(int i = 0; i < costs.length; ++i){
            int[] cost = costs[i];
            int diff = cost[1] - cost[0];
            // pair nPair = new pair(diff, i);
            // System.out.println(nPair.diff + " " + nPair.idx);
            pq.add(new pair(diff, i));
        }
        
        int n = costs.length;
        int ans = 0;
        for(int i = 0; i < n/2; ++i){
            pair front = pq.remove();
            // System.out.print(front.diff + " ");
            int idx = front.idx;
            ans += costs[idx][0];
        }
        
        while(pq.size() > 0){
            pair front = pq.remove();
            // System.out.print(front.diff + " ");
            int idx = front.idx;
            ans += costs[idx][1];
        }
        
        return ans;
    }
}