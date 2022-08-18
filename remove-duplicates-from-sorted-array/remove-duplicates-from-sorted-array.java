class Solution {
    public int removeDuplicates(int[] nums) {
 // Initialize start index to 0 end index to 1 and count to 1 as it is mentioned in the problem statement that min length of nums array will be 1
 // thus, if nums length is 1 then it will simple be returned and won't go in while loop
       int start = 0, end=1, count=1;;  
       while(end!=nums.length)
       {
           if(nums[start]==nums[end]) {
               end++;                  // Increment the end index if nums[start] and nums[end] is equal
           }
           else {
		   //Assign nums[end] to nums[start+1] as nums[start] and nums[end[ is not equal and increment start, end indexes and count
               nums[start+1]=nums[end];  
               start++;
               end++;
               count++;
           }
       }
        return count;
    }
}