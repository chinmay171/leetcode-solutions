// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int transitionPoint(int arr[], int left, int right) {
        // code here
        // int left = 0;
        // int right = n-1;
        int ans = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(arr[mid] == 0){
                left = mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }
        }
        return ans;
    }
    
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int left = 0;
        int right = m-1;
        int ans = -1;
        int noOfOnes = 0;
        for(int i = 0; i<n;++i){
            int transitionPt = transitionPoint(arr[i], 0, right);
            if(transitionPt != -1 && m-transitionPt > noOfOnes){
                ans = i;
                noOfOnes = m-transitionPt;
                right = transitionPt-1;
            }
        }
        return ans;
    }
}