class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> stk = new ArrayList<>();
        
        for(int i = 0; i < asteroids.length; ++i){
            int right = asteroids[i];
            
            if(right > 0) stk.add(right);
            else{
                if(stk.size() == 0 || stk.get(stk.size()-1) < 0){
                    stk.add(right);
                }else if(stk.get(stk.size()-1) < -right){
                    stk.remove(stk.size()-1);
                    i--;
                }else if(stk.get(stk.size()-1) == -right){
                    stk.remove(stk.size()-1);
                }
            }
        }
        
        int[] ans = new int[stk.size()];
        for(int i = 0; i < stk.size(); ++i){
            ans[i] = stk.get(i);
        }
        return ans;
    }
}