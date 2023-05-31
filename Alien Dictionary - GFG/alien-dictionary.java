//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // a -> b , d;
        // b -> 
        // c -> a;
        // d -> b;
        
        ArrayList<Integer>[] adj = new ArrayList[K];
        for(int i = 0; i < K; ++i) adj[i] = new ArrayList<>();
        int[] incoming = new int[K];
        
        for(int i = 0; i < N-1; ++i){
            String curr = dict[i];
            String next = dict[i+1];
            
            int j = 0;
            while(j < curr.length() && j < next.length()){
                if(curr.charAt(j) != next.charAt(j)){
                    adj[curr.charAt(j) - 'a'].add(next.charAt(j) - 'a');
                    incoming[next.charAt(j) - 'a']++;
                    break;
                }
                j++;
            }
        }
        
        // for(int i = 0; i < K; ++i){
        //     System.out.print(i + " -> ");
        //     for(int in : adj[i]){
        //         System.out.print(in + " ");
        //     }
        //     System.out.println();
        // }
        
        // for(int i : topo){
        //     System.out.print(i + " ");
        // }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < K; ++i)
            if(incoming[i] == 0) q.add(i);
        
        String ans = "";
        while(q.size() > 0){
            int front = q.remove();
            char ch = (char)(97 + front);
            ans = ans + ch;
            
            for(int nbr : adj[front]){
                incoming[nbr]--;
                if(incoming[nbr] == 0) q.add(nbr);
            }
        }
        // System.out.print(ans);
        return ans;
    }
}