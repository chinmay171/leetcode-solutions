//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    static class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; ++i){
            arr[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(arr, (a1, a2) -> a1.val - a2.val);
        int ans = 0;
        boolean[] vis = new boolean[n];
        
        for(int i = 0; i < n; ++i){
            if(vis[i] == true || arr[i].idx == i) continue;
            
            int j = i;
            int currLen = 0;
            while(vis[j] != true){
                vis[j] = true;
                currLen++;
                j = arr[j].idx;
            }
            
            ans += (currLen-1);
        }
        
        return ans;
    }
}