class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        int s1 = 0;
        int s2 = 1;
        int s3 = 2;
        
        int currAns = 0;
        
        // for(int i : nums) System.out.print(i + " ");
        
        while(s3 < nums.length){
            
            int largeSide = nums[s3];
            int sumSide = nums[s2] + nums[s1];
            
            if(largeSide < sumSide){
                currAns = largeSide + sumSide;
            }
            
            s1++;
            s2++;
            s3++;
        }
        
        return currAns;
    }
}