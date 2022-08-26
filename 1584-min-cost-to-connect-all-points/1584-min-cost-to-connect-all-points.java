public class Pair implements Comparable<Pair>{
    int idx;
    int weight;
    Pair(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
    
    public int compareTo(Pair other){
        return (this.weight - other.weight);
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int n = points.length;
        boolean[] vis = new boolean[n];
        q.add(new Pair(0, 0));
        
        int cost = 0;
        int count = 0;
        while(q.size() > 0 && count < n){
            Pair top = q.remove();
            
            if(vis[top.idx] == true)continue;
            vis[top.idx] = true;
            
            cost += top.weight;
            count++;
            
            for(int i = 0; i < n; ++i){
                int dist = Math.abs(points[top.idx][0] - points[i][0]) + 
                           Math.abs(points[top.idx][1] - points[i][1]);
                q.add(new Pair(i, dist));
            }
        }
        
        return cost;
    }
}