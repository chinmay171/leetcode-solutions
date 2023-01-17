public class Solution {
    // you need treat n as an unsigned value
    public int swap(int n, int left, int right){
        int leftMask = (1 << left);
        int rightMask = (1 << right);
        
        boolean isLeftSet = ((n & leftMask) != 0);
        boolean isRightSet = ((n & rightMask) != 0);
        
        if(isLeftSet != isRightSet){
            n = n ^ leftMask;
            n = n ^ rightMask;
        }
        
        return n;
    }
    public int reverseBits(int n) {
        int left = 0;
        int right = 31;
        while(left <= right){
            n = swap(n, left, right);
            left++;
            right--;
        }
        return n;
    }
}