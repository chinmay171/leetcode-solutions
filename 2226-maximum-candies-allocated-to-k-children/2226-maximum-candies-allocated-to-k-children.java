class Solution {
    
    public boolean check(int[] candies, long k, int mid){
        if(mid == 0) return true;
        
        long ourK = 0;
        for(int i : candies){
            ourK += i / mid;
            
            if(ourK >= k) return true;
        }
    
        return false;
    }
    
    public int maximumCandies(int[] candies, long k) {
        
        int low = 1;
        int high = 0;
        for(int i : candies){
            high = Math.max(i, high);
        }
        
        while(low < high){
            int mid = low + (high - low) / 2;
            
            if(check(candies, k, mid)) low = mid + 1;
            else high = mid;
        }
        
        // return low - 1;
        return check(candies, k, low) ? low : low-1;
    }
}