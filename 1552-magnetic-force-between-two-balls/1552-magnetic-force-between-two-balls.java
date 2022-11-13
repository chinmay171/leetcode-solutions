class Solution {
    
    public boolean isGapValid(int[] position, int totalBalls, int gap){
        
        int placed = 1;
        int prevBallPlaced = position[0];
        
        for(int i = 1; i < position.length; ++i){
            if(position[i] - prevBallPlaced >= gap){
                placed++;
                prevBallPlaced = position[i];
                if(placed == totalBalls){
                    return true;
                }
            }
        }
        
        if(placed < totalBalls){
            return false;
        }
        return true;
    }
    
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        
        int len = position.length;
        int low = 0;
        int high = position[len - 1];
        
        int ans = m+1;
        
        while(low < high){
            
            int mid = low + (high - low) / 2;
            
            boolean isGapPossible = isGapValid(position, m, mid);
            
            if(isGapPossible == true){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        
        return ans;
    }
}