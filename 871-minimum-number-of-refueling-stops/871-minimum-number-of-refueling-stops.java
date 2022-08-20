class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        int curr = startFuel;
        int i = 0;
        while(curr<target)
        {
            while(i<stations.length && curr>=stations[i][0])
            {
                maxheap.add(stations[i][1]);
                i++;
            }
            
            if(maxheap.size()==0) return -1;
            res++;
            curr+=maxheap.remove();
            
            
        }
        
        return res;
    }
}