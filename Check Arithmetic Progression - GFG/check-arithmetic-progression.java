//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
        // code here
        HashSet<Integer> set = new HashSet<>();
        
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        
        for(int val : arr){
            set.add(val);
            
            if(val < min){
                smin = min;
                min = val;
            }else if(val < smin){
                smin = val;
            }
        }
        
        int d = smin - min;
        // System.out.print(d + " " + smin + " " + min);
        for(int i = 1; i <= n; ++i){
            if(set.contains(min) == true){
                min = min + d;
            }else{
                return false;
            }
        }
        return true;
    
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[]=new int[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(a1[i]);
            }
            Solution ob=new Solution();

            boolean ans=ob.checkIsAP(a,n);
            if(ans==true)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}




// } Driver Code Ends