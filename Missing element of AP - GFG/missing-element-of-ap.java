// { Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMissing(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    int findMissing(int[] arr, int n) {
        // code here
        int left = 0;
        int right = arr.length-1;
        int d = (arr[n-1]-arr[0])/arr.length;
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            
            int actualVal = arr[mid];
            int expectedVal = arr[0] + d*mid;
            if(actualVal == expectedVal){
                left = mid+1;
            }else{
                ans = expectedVal;
                right = mid-1;
            }
        }
        return ans;
    }
}
