class Solution {
    public int minimumLength(String s) {
//         int ans = s.length();
        
//         int left = 0;
//         int right = ans - 1;
//         while(left <= right){
            
//             if(s.charAt(left) != s.charAt(right)){
//                 if(right < s.length()-1 && s.charAt(left) == s.charAt(right+1)){
//                     left++;
//                     ans--;
//                 }else if(left > 0 && s.charAt(left-1) == s.charAt(right)){
//                     right--;
//                     ans--;
//                 }else{
//                     return ans;
//                 }
//             }else{
//                 left++;
//                 right--;
//                 ans-=2;
//             }
//         }
        
//         if(right>left){
//             return 0;
//         }
        
//         return ans;
        
        int left = 0,right = s.length()-1;
        while(left < right && s.charAt(left) == s.charAt(right) )
        {
            char ch = s.charAt(left);
            while(left < right && ch == s.charAt(left) )
                left++;
            while(left <= right && ch == s.charAt(right) )
                right--;
                
        }
        return  right-left+1;
        
    }
}