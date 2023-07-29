//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public static class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    
    public int largestRectangleArea(int[] heights) {
        Pair[] p = new Pair[heights.length];
        for(int i = 0; i < heights.length; ++i)
            p[i] = new Pair(heights[i], i);

        int[] next = new int[heights.length];
        Stack<Pair> stk1 = new Stack<>();
        for(int i = heights.length-1; i >= 0; --i){
            int curr = p[i].val;
            while(stk1.size() > 0 && stk1.peek().val >= curr)
                stk1.pop();
            if(stk1.size() == 0) next[i] = heights.length-1;
            else next[i] = stk1.peek().idx - 1;
            stk1.push(p[i]);
        }

        int[] prev = new int[heights.length];
        Stack<Pair> stk2 = new Stack<>();
        for(int i = 0; i < heights.length; ++i){
            int curr = p[i].val;
            while(stk2.size() > 0 && stk2.peek().val >= curr)
                stk2.pop();
            if(stk2.size() == 0) prev[i] = 0;
            else prev[i] = stk2.peek().idx + 1;
            stk2.push(p[i]);
        }

        int ans = 0;
        for(int i = 0; i < heights.length; ++i)
            ans = Math.max(ans, heights[i] * (next[i] - prev[i] + 1));
        return ans;
    }
    
    public int maxArea(int matrix[][], int n, int m) {
        int[] h = new int[matrix[0].length];
        int ans = 0;
        for(int  i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] == 1) h[j] += 1;
                else h[j] = 0;
            }
            int curr = largestRectangleArea(h);
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}