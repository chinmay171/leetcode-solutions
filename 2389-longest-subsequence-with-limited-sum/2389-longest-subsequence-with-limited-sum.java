class Solution {
    
    public int binarySearch(int[] nums, int sum){
        int left = 0;
        int right = nums.length - 1;
        int idx = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(nums[mid] == sum) return mid+1;
            else if(nums[mid] < sum){
                idx = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(nums[0] > sum) return idx;
        return idx+1;
    }
    
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
        int[] preNums = new int[nums.length];
        int total = 0;
        for(int i = 0; i < nums.length; ++i){
            preNums[i] = total + nums[i];
            total = preNums[i];
        }
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; ++i){
            ans[i] = binarySearch(preNums, queries[i]);
        }
        
        return ans;
    }
}