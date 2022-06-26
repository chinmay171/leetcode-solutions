// { Driver Code Starts
import java.util.*;



class Count_0_In_Sorted_Matrix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new GfG().countZeros(arr, n));
		t--;
		}
	}
}// } Driver Code Ends


class GfG
{
    /*you are required to complete this method*/
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
    int countZeros(int A[][], int N)
    {
        // Your code here
        int right = N-1;
        int ans = 0;
        for(int i = 0;i<N; ++i){
            int transitionPt = transitionPoint(A[i], 0, right);
            if(transitionPt == -1){
                ans += N;
            }else{
                ans += transitionPt;
            }
        }
        return ans;
    }
}