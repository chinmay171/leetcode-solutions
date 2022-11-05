class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                res.add(mid);
                int tempLeft = mid - 1;
                
                while(tempLeft > -1 && nums[tempLeft] == target){
                    res.add(tempLeft);
                    tempLeft--;
                }
                
                int tempRight = mid + 1;

                while(tempRight < nums.length && nums[tempRight] == target){
                    res.add(tempRight);
                    tempRight++;
                }
                
                break;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        
        Collections.sort(res);
        
        return res;
    }
}