// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    
    public static int maxOfArray(int[] books, int N){
        int max = 0;
        for(int i = 0; i<N; ++i){
            max = Math.max(max, books[i]);
        }
        return max;
    }
    
    public static int sumOfArray(int[] books, int N){
        int sum = 0;
        for(int i = 0; i<N; ++i){
            sum += books[i];
        }
        return sum;
    }
    
    public static boolean isPossible(int[] pages, int maxLoads, int books, int totalStudents){
        int currStudents = 1;
        int currPages = 0;
        for(int i = 0;currStudents<= totalStudents && i<books; i++){
            if(currPages+pages[i] <= maxLoads){
                currPages += pages[i];
            }else{
                currStudents++;
                currPages = pages[i];
            }
        }
        if(currStudents > totalStudents) return false;
        return true;
    }
    
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int left = maxOfArray(A, N);
        int right = sumOfArray(A, N);
        int ans = right;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(isPossible(A,mid,N,M) == true){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
};