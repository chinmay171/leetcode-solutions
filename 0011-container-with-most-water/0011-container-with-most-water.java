class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right){
            answer = Math.max(answer, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return answer;
    }
}