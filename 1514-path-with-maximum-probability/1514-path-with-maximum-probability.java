public class Pair implements Comparable<Pair>{
    int node;
    double prob;
    
    Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
    
    public int compareTo(Pair other){
        if(other.prob > this.prob) return +1;
        else if(other.prob == this.prob) return 0;
        else return -1;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] Prob, int start, int end) {
        ArrayList<Pair>[] adj = new ArrayList[n];
        
        for(int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        int i = 0;
        for(int[] edge : edges){
            adj[edge[0]].add(new Pair(edge[1], Prob[i]));
            adj[edge[1]].add(new Pair(edge[0], Prob[i++]));
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 1.0));
        
        double[] vis = new double[n];
        Arrays.fill(vis, -1);
        
        while(q.size() > 0){
            Pair top = q.remove();
            
            if(vis[top.node] != -1)continue;
            vis[top.node] = top.prob;
            
            for(Pair nbr : adj[top.node]){
                q.add(new Pair(nbr.node, top.prob * nbr.prob));
            }
        }
        
        return (vis[end] == -1) ? 0 : vis[end];
    }
}