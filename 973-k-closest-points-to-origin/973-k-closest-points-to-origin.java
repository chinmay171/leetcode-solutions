class Solution {
    static class Pair{
        public int x, y;
    }
    
    static class Euclidean implements Comparator<Pair>{
        public int compare(Pair c1, Pair c2){
            double d1 = Math.sqrt((c1.x * c1.x) + (c1.y * c1.y));
            double d2 = Math.sqrt((c2.x * c2.x) + (c2.y * c2.y));
            
            if(d1 < d2){
                return -1;
            }else if(d2 < d1){
                return 1;
            }else return 0;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Euclidean());
        
        for(int i = 0; i<points.length; ++i){
            Pair p = new Pair();
            p.x = points[i][0];
            p.y = points[i][1];
            pq.add(p);
        }
        int count = 0;
        int[][] res = new int[k][2];
        while(count < k){
            Pair closest = pq.remove();
            res[count][0] = closest.x;
            res[count][1] = closest.y;
            count++;
        }
        return res;
    }
}