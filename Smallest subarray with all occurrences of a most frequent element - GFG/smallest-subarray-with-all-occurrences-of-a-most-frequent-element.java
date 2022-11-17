//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        int si = -1;
        int li = -1;
        
        int mFreq = 0;
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> sIdx = new HashMap<>();
        for(int i = 0; i < a.length; ++i){
            freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
            
            if(sIdx.containsKey(a[i]) == false){
                sIdx.put(a[i], i);
            }
            
            if(freq.get(a[i]) > mFreq){
                mFreq = freq.get(a[i]);
                si = sIdx.get(a[i]);
                li = i;
            }else if(freq.get(a[i]) == mFreq){
                if(i - sIdx.get(a[i]) < li - si){
                    si = sIdx.get(a[i]);
                    li = i;
                }
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = si; i <= li; ++i){
            arr.add(a[i]);
        }
        
        return arr;
        
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            


// } Driver Code Ends