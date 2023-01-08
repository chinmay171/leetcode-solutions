class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length;
        
        int max = 0;
        for(int i = 0; i < points.length; ++i){
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; ++j){
                if(i == j) continue;
                int xCoord = points[j][0] - points[i][0];
                int yCoord = points[j][1] - points[i][1];
                
                double slope = 0;
                if(xCoord == 0){
                    slope = Double.POSITIVE_INFINITY;
                }else{
                    slope = yCoord / (double)xCoord;
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
        }
        
        return max+1;
    }
}