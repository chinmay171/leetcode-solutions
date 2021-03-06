// { Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG {
    int transitionPoint(int arr[], int n) {
        // code here
        int left = 0;
        int right = n-1;
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
}