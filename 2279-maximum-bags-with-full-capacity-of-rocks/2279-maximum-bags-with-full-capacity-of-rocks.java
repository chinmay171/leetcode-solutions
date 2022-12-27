class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int extra) {
        int n = rocks.length;
        int ans = 0;
        for(int i = 0; i < n; ++i){
            rocks[i] = capacity[i] - rocks[i];
            
            if(rocks[i] == 0){
                ans++;
            }
        }
        Arrays.sort(rocks);
        
        int i = 0;
        while(rocks[i] == 0){
            i++;
        }
        for(; i < n; ++i){
            if(extra >= rocks[i]){
                extra -= rocks[i];
                ans++;
            }else break;
        }
        
        return ans;
    }
}


// [4, 3, 3]
// 6