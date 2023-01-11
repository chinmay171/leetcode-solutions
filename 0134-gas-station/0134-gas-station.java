class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int dificit = 0;
        int start = 0;
        int fuel = 0;
        
        for(int i = 0; i < gas.length; ++i){
            fuel += gas[i] - cost[i];
            
            if(fuel < 0){
                start = i + 1;
                dificit += -fuel;
                fuel = 0;
            }
        }
        
        if(fuel >= dificit) return start;
        return -1;
    }
}