class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        while(n != 1){
            if(set.contains(n) == true) return false;
            
            set.add(n);
            
            int curr = 0;
            while(n > 0){
                int rem = n % 10;
                n = n / 10;
                curr = curr + (rem*rem);
            }
            n = curr;
        }
        
        return true;
    }
}