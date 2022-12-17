//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < k; ++i){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int disEle = map.size();
        ans.add(disEle);
            
        for(int i = k; i < n; ++i){
            //addtion of element
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
            //removal of element
            if(map.get(arr[i-k]) == 1){
                map.remove(arr[i-k]);
            }else{
                map.put(arr[i-k], map.getOrDefault(arr[i-k], 0) - 1);    
            }
            
            disEle = map.size();
            ans.add(disEle);
        }
        
        return ans;
    }
}

