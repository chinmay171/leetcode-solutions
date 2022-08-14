class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        
//         int i = nums1.length;
//         int j = nums2.length;
        
//         int sum1 = 0;
//         int sum2 = 0;
        
//         int sum = 0;
        
//         while(i > 0 && j > 0){
//             if(nums1[i-1] == nums2[j-1]){
//                 sum += nums1[i-1] + Math.max(sum1, sum2);
                
//                 sum1 = 0;
//                 sum2 = 0;
                
//                 i--;
//                 j--;
//             }else if(nums1[i-1] > nums2[j-1]){
//                 sum1 =nums1[i-1] + sum1;
//                 i--;
//             }
//             else if(nums2[j-1] > nums2[i-1]){
//                 sum2 = nums2[j-1] + sum2;
//                 j--;
//             }
//         }
        
//         while(i > 0){
//             sum1 =nums1[i-1] + sum1;
//             i--;
//         }
//         while(j > 0){
//             sum2 =nums2[j-1] + sum2;
//             j--;
//         }
        
//         int ans = sum + Math.max(sum1, sum2);
//         return ans;
        
        int i = 0; 
        int j = 0; 
        
        int n = nums1.length;
        int m = nums2.length;
        
        long sum1 = 0, sum2 = 0, sum = 0;
        
        while(i < n && j < m){
            if(nums1[i] == nums2[j]){
                sum += nums2[j] + Math.max(sum1, sum2);
                
                sum1 = 0;
                sum2 = 0;
                
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                sum1 += nums1[i];
                i++;
            }else{
                sum2 += nums2[j];
                j++;
            }
        }
        
        while( i < n){
            sum1 += nums1[i];
            i++;
        }
        while( j < m ){
            sum2 += nums2[j];
            j++;
        }
        
        // return (int)(sum + Math.max(sum1, sum2)) % 1000000007;
        return (int)((sum + Math.max(sum1, sum2)) % 1000000007);
    }
}