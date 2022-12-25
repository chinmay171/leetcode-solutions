class Solution {
    public int trap(int[] height) {
//         int left = 0;
//         int right = height.length - 1;
//         int leftMax = 0;
//         int rightMax = 0;
//         int res = 0;
        
//         while(left <= right){
//             if(height[left] <= height[right]){
//                 if(height[left] >= leftMax) leftMax = height[left];
//                 else res += (leftMax - height[left]);
//                 left++;
//             }else{
//                 if(height[right] >= rightMax) rightMax = height[right];
//                 else res += (rightMax - height[right]);
//                 right--;
//             }
//         }
        
//         return res;
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int rightMax = -1;
        for(int i = 0; i < n; ++i){
            pre[i] = Math.max(rightMax, height[i]);
            rightMax = Math.max(rightMax, height[i]);
        }

        int leftMax = -1;
        for(int i = n-1; i >= 0; --i){
            suf[i] = Math.max(leftMax, height[i]);
            leftMax = Math.max(leftMax, height[i]);
        }
        
        int res = 0;
        
        for(int i = 0; i < n; ++i){
            res += (Math.min(pre[i], suf[i]) - height[i]);
        }
        
        return res;
    }
}