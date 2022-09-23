class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        int[] main = new int[n];
        Arrays.fill(main, Integer.MAX_VALUE);
        main[src] = 0;
        
        for(int i = 0; i <= k; ++i){
            int[] temp = new int[n];
            
            for(int  j = 0; j < n; j++) temp[j] = main[j];
            
            for(int[] edge : edges){
                int incoming = edge[0];
                int outgoing = edge[1];
                int price = edge[2];
                
                if(main[incoming] == Integer.MAX_VALUE) continue;
                temp[outgoing] = Math.min(temp[outgoing], main[incoming] + price);
            }
            
            for(int j = 0; j < n; j++) main[j] = temp[j];
        }
        
        return (main[dst] == Integer.MAX_VALUE) ? -1 : main[dst];
    }
}