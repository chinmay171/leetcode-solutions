class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        
        for(int i = 0; i < k; ++i){
            leftSum += cardPoints[i];
        }
        int n = cardPoints.length;
        int ans = leftSum;
        int j = 0;
        for(int i = k-1; i >= 0; --i){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[n-1-j];
            j++;
            ans = Math.max(ans, leftSum + rightSum);
        }
        
        return ans;
    }
}