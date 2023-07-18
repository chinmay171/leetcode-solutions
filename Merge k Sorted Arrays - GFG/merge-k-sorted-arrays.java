//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    public static class Pair{
		int ele;
		int arrayNo;
		Pair(int ele, int arrayNo){
			this.ele = ele;
			this.arrayNo = arrayNo;
		}
	}
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.ele - p2.ele);
		int[] idxNo = new int[k];
		ArrayList<Integer> ans = new ArrayList<>();

		for(int i = 0; i < arr.length; ++i)
			pq.add(new Pair(arr[i][0], i));
		while(pq.size() > 0){
			Pair front = pq.remove();
			// addition into answer
			ans.add(front.ele);
			// addition of new pair in pq
			idxNo[front.arrayNo]++; // 
			if(idxNo[front.arrayNo] >= arr[front.arrayNo].length) continue;
			pq.add(new Pair(arr[front.arrayNo][idxNo[front.arrayNo]], front.arrayNo));
		}
		return ans;
    }
}