class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        //Normal LIS (N^2 approach) Time Limit Exceeded
//         int n = obstacles.length;
//         int[] ans = new int[n];
//         Arrays.fill(ans, 1);
        
//         for(int i = 0; i < n; ++i)
//             for(int j = 0; j < i; ++j)
//                 if(obstacles[j] <= obstacles[i]) 
//                     ans[i] = Math.max(ans[i], ans[j] + 1);
//         return ans;
        int n = obstacles.length;
        int length = 0;
        int[] result = new int[n];
        int[] increasingSubseq = new int[n];
        for (int i = 0; i < n; ++i) {
            int left = 0, right = length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (increasingSubseq[mid] <= obstacles[i])
                    left = mid + 1;
                else
                    right = mid;
            }
            result[i] = left + 1;
            if (length == left)
                length++;
            increasingSubseq[left] = obstacles[i];
        }
        return result;
        
    }
}