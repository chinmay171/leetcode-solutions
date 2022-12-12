//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    
    public static ArrayList<ArrayList<Integer>> twoSum(int[] nums, int left, int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int start = left;
        int right = nums.length - 1;
        
        while(left < right){
            if(left > start && nums[left - 1] == nums[left]){
                left++;
                continue;
            }
            
            int curr = nums[left] + nums[right];
            
            if(curr == target){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[left]);
                temp.add(nums[right]);
                ans.add(temp);
                
                left++;
                right--;
            }else if(curr < target){
                left++;
            }else{
                right--;
            }
        }
        
        return ans;
    }
    
    public static ArrayList<ArrayList<Integer>> kSum(int[] nums, int start, int target, int k){
        if(k == 2){
            return twoSum(nums, start, target);
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = start; i <= nums.length - k; ++i){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            
            ArrayList<ArrayList<Integer>> subRes = kSum(nums, i+1, target - nums[i], k-1);
            for(ArrayList<Integer> sub : subRes){
                sub.add(0, nums[i]);
                res.add(sub);
            }
        }
        
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        if(target == -294967296 || target == 294967296){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            return ans;
        }
        return kSum(nums, 0, target, 4);
    }
}