class Solution {
    HashSet<Integer> one;
    HashSet<Integer> two;

    public boolean dfs(int src, int[][] graph, int set, int[] vis){

        if(vis[src] == 2) return true;
        if(vis[src] == 1){
            if(set == 2 && two.contains(src) == true) return false;
            if(set == 1 && one.contains(src) == true) return false;
            return true;
        }
        vis[src] = 1;

        int currSet = -1;
        if(set == -1 || set == 2) currSet = 1;
        else if(set == 1) currSet = 2;

        if(currSet == 1) one.add(src);
        if(currSet == 2) two.add(src);

        for(int nbr : graph[src])
            if(dfs(nbr, graph, currSet, vis) == false) return false;
        vis[src] = 2;

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        one = new HashSet<>();
        two = new HashSet<>();

        int[] vis = new int[graph.length];  

        for(int i = 0; i < graph.length; ++i)
            if(vis[i] != 2 && dfs(i, graph, -1, vis) == false) return false;

        return true;
    }
}