class Solution {
    List<String> path = new ArrayList<>();
    public void dfs(String src, HashMap<String , PriorityQueue<String>> adj){
        while(adj.get(src).size() > 0){
            String nbr = adj.get(src).remove();
            dfs(nbr, adj);
        }
        path.add(src);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String , PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            if(adj.containsKey(src) == false) adj.put(src, new PriorityQueue<>());
            if(adj.containsKey(dest) == false) adj.put(dest, new PriorityQueue<>());
            
            adj.get(src).add(dest);
        }
        dfs("JFK", adj);
        Collections.reverse(path);
        return path;
    }
}