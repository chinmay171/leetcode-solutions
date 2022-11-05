class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        
        for(int i = 1; i <= n; ++i){
            String curr = "";
            if(i%3 == 0){
                curr += "Fizz";
            }
            if(i%5 == 0){
                curr += "Buzz";
            }
            if(curr.length() == 0){
                curr += i;
            }
            res.add(curr);
        }
        
        return res;
    }
}