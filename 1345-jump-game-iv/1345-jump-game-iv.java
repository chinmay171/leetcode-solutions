class Solution {
    class pair{
        int index;
        int level;
        pair(int index, int level){
            this.index = index;
            this.level = level;
        }
    }
    
    public int minJumps(int[] arr) {
        boolean[] vis = new boolean[arr.length];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < arr.length; ++i){
            if(graph.containsKey(arr[i]) == false) 
                graph.put(arr[i], new ArrayList<>());
            List<Integer> temp = graph.get(arr[i]);
            temp.add(i);
            graph.put(arr[i], temp);
        }
        
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(0, 0));
        vis[0] = true;
        
        while(q.size() > 0){
            pair top = q.remove();
            vis[top.index] = true;
            if(top.index == arr.length-1) return top.level;
            // all possible same value positions
            if(graph.containsKey(arr[top.index])){
                for(Integer a : graph.get(arr[top.index])){
                    if(vis[a] == false && a > 0 && a < arr.length)
                        q.add(new pair(a, top.level+1));
                }
                graph.remove(arr[top.index]);
            }
            // jump to prev index
            if(top.index > 0 && vis[top.index-1] == false) 
                q.add(new pair(top.index-1, top.level+1));
            // jump to next index
            if(top.index < arr.length-1 && vis[top.index+1] == false)
                q.add(new pair(top.index+1, top.level+1));
        }
        return -1;
    }
}