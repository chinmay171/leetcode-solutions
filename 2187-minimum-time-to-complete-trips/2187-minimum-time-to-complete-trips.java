class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long min1 = time[0];
        for(int t : time) min1 = Math.min(min1, t);
        long right = totalTrips * min1;
        
        while(left < right){
            long mid = left + (right - left) / 2;
            
            // actual trip;
            long actualTrips = 0;
            for(int t : time){
                actualTrips += mid / t;
            }
            
            if(actualTrips < totalTrips){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return left;
    }
}