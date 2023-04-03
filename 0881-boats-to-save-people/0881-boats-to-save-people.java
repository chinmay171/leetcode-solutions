class Solution {
    // 1 2 4 5
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int l = 0;
        int r = people.length-1;
        int count = 0;
        
        while(l <= r){
            int currWieght = people[l] + people[r];
            
            if(currWieght <= limit){
                l++;
            }
            count++;
            r--;
        }
        
        return count;
    }
}