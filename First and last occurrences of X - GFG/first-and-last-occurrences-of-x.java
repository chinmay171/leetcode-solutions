//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String inputLine[] = br.readLine().trim().split(" "); 
            int n = Integer.parseInt(inputLine[0]); 
            int x = Integer.parseInt(inputLine[1]);
            
            int arr[] = new int[(int)(n)];
            
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.firstAndLast(arr, n, x); 
            
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    } 
} 
            



// } Driver Code Ends


//User function Template for Java
class Solution{

    public static int firstOccurance(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        int idx = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == x){
                idx = mid;
                right = mid - 1;
            }else if(arr[mid] > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return idx;
    }
    
    public static int lastOccurance(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        int idx = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == x){
                idx = mid;
                left = mid + 1;
            }else if(arr[mid] > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return idx;
    }

    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        ArrayList<Integer> ans = new ArrayList<>();
        
        int firstOcc = firstOccurance(arr, x);
        int lastOcc = lastOccurance(arr, x);
        
        if(firstOcc == -1 && lastOcc == -1){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(-1);
            return res;
        }
        
        ans.add(firstOcc);
        ans.add(lastOcc);
        return ans;
    }
}
