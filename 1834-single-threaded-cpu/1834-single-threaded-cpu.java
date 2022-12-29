class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        int[][] nTask = new int[n][3];
        for(int i = 0; i < n; ++i){
            nTask[i][0] = i;
            nTask[i][1] = tasks[i][0];
            nTask[i][2] = tasks[i][1];
        }
        
        Arrays.sort(nTask, (a, b) ->{
            if(a[1] == b[1]) return a[2] - b[2];
            else return a[1] - b[1];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]); 
        
        int time = 0;
        int idx = 0;
        int curr = 0;
        int[] res = new int[n];
        while(curr < n){
            while(idx < n && nTask[idx][1] <= time){
                pq.add(nTask[idx]);
                idx++;
            }
            
            if(pq.isEmpty()){
                time = nTask[idx][1];
                continue;
            }
            
            int[] next = pq.remove();
            res[curr] = next[0];
            time += next[2];
            curr++;
        }
        
        return res;
    }
}