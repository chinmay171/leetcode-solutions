class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalsum=0,n=matchsticks.length;
        if(n<4)return false;
        
        for(int el : matchsticks){
            totalsum+=el;
        }
        
        if(totalsum%4!=0)return false;
        int side = totalsum/4;
        int[] sides = new int[]{side,side,side,side};
        Arrays.sort(matchsticks);
        return makesquare_helper(n-1,matchsticks,sides,n);
    }
    
    public boolean makesquare_helper(int i,int[] matchstick,int[] sides,int n){
        if(i==-1){
            return sides[0]==0 && sides[1]==0 && sides[2]==0 && sides[3]==0 ;
        }
        
        for(int j=0;j<4;j++){
            if(matchstick[i]<=sides[j]){
            
            sides[j]-=matchstick[i];
            if(makesquare_helper(i-1,matchstick,sides,n))return true;
            sides[j]+=matchstick[i];
            }
        }
        return false;
    }
    
}