class Solution {
    
    public boolean check(int num){
        
//         int k = i;
        
//         while(k > 0){
//             int temp = k % 10;
//             if(i % temp != 0) return false;
//             k = k / 10;
//         }
//         return true;
        for (int n = num; n > 0; n /= 10)
            if (n % 10 == 0 || num % (n % 10) != 0) return false;
        return true;
    }
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; ++i){
            if(check(i) == true){
                ans.add(i);
            }
        }
        
        return ans;
    }
}