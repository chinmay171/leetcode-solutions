class Solution {
    public int convertToMinute(String time){
        String hrs = time.substring(0, 2);
        String minutes = time.substring(3);
        
        int timeInMinutes = Integer.parseInt(hrs) * 60
                            + Integer.parseInt(minutes);
        return timeInMinutes;
    }
    
    public int convertTime(String current, String correct) {
        int currInMinute = convertToMinute(current);
        // System.out.println(currInMinute);
        int correctInMinute = convertToMinute(correct);
        // System.out.println(correctInMinute);
        int timeDiff = correctInMinute - currInMinute;
        
        int count = 0;
        if(timeDiff % 60 >= 0){
            count += timeDiff / 60;
            timeDiff = timeDiff % 60;
        }
        if(timeDiff == 0)return count;
        /////////////////////////////////////
        if(timeDiff % 15 >= 0){
            count += timeDiff / 15;
            timeDiff = timeDiff % 15;
        }
        if(timeDiff == 0)return count;
        /////////////////////////////////////
        if(timeDiff % 5 >= 0){
            count += timeDiff / 5;
            timeDiff = timeDiff % 5;
        }
        if(timeDiff == 0)return count;
        ////////////////////////////////////
        if(timeDiff % 1 >= 0){
            count += timeDiff / 1;
            timeDiff = timeDiff % 1;
        }
        return count;
        /////////////////////////////////////
    }
}