//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int target = Integer.parseInt(element[1]);
		    
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.findClosest(arr, n, target));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static int findClosest(int arr[], int n, int target) 
    { 
        int start = 0;
        int end = n - 1;
        
        int justSmall = -1;
        int justLarge = -1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(arr[mid] == target){
                return arr[mid];
            }
            else if(arr[mid] < target){
                justSmall = mid;
                start = mid + 1;
            }else{
                justLarge = mid;
                end = mid - 1;
            }
        }
        
        if(justSmall == -1){
            return arr[0];
        }
        if(justLarge == -1){
            return arr[n-1];
        }
        
        if(target > arr[justSmall] && target < arr[justLarge]){
            int diff1 = target - arr[justSmall];
            int diff2 = arr[justLarge] - target;
            
            if(diff1 == diff2){
                return arr[justLarge];
            }else{
                if(diff1 < diff2){
                    return arr[justSmall];
                }else{
                    return arr[justLarge];
                }
            }
        }
        return -1;
    } 
}

