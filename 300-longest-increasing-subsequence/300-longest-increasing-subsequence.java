class Solution {
//     public int memo(int[] nums, int idx, int x, int[][] dp){
//         if(idx == nums.length)return 0;
     
//         if(dp[idx][x+1] != -1)return dp[idx][x+1];
//         int yes = (x == -1 ||nums[idx] > nums[x])
//                     ? memo(nums, idx+1, idx, dp)+1 : 0;
//         int no = memo(nums, idx+1, x, dp);
        
//         return dp[idx][x+1] = Math.max(yes, no);
//     }
    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length+1][nums.length+1];
        // for(int i = 0; i<=nums.length; ++i){
        //     for(int j =0; j<=nums.length;++j){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memo(nums, 0, -1, dp);
//         int n = nums.length;
//         int[] dp = new int[n];
        
//         int maxLIS = Integer.MIN_VALUE;
//         // ArrayList<Integer> LIS = new ArrayList<>();
//         for(int i = 0; i<n; ++i){
//             // ArrayList<Integer> currLIS = new ArrayList<>();
//             dp[i] = 1;
            
//             for(int j = 0; j<i; ++j){
//                 if(nums[i] > nums[j]){
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//                     // currLIS.add(nums[i]);
//                 }
//             }
//             maxLIS = Math.max(maxLIS, dp[i]);
//             // if(LIS.size() < currLIS.size()){
//             //     LIS = currLIS;
//             // }
//         }
//         return maxLIS;
        
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<n; ++i){
            int lb = lowerBound(arr, nums[i]);
            if(arr.size() == lb){
                arr.add(nums[i]);
            }else{
                arr.set(lb, nums[i]);
            }
        }
        return arr.size();
    }
    public int lowerBound(ArrayList<Integer> arr, int target){
        int low = 0;
        int high = arr.size()-1;
        int idx = arr.size();
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(arr.get(mid) < target){
                low = mid+1;
            }else{
                high = mid-1;
                idx = mid;
            }
        }
        return idx;
    }
}