class Solution {
    public int maxOfPiles(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; ++i){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    
    public boolean isPossible(int[] piles, int h, int speed){
        int currHours = 0;
        for(int banana : piles){
            currHours += (double)banana/speed;
            if(banana%speed != 0) currHours++;
        }
        if(currHours <= h)return true;
        return false;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxOfPiles(piles);
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(piles,h,mid) == true){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}