//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    public static class modPair{
		double ratio;
		int weight;
		int value;

		public modPair(double ratio, int value, int weight){
			this.ratio = ratio;
			this.value = value;
			this.weight = weight;
		}
	}
	
    double fractionalKnapsack(int w, Item items[], int n) {
        
        modPair[] mPair = new modPair[n];
		for(int i = 0; i < n; i++){
			double r = (double)items[i].value / (double)items[i].weight;
			mPair[i] = new modPair(r, items[i].value, items[i].weight);
		}

		Arrays.sort(mPair, (modPair a, modPair b) ->
							(b.ratio > a.ratio) ? 1 :
								(a.ratio > b.ratio) ? -1 :
									0);

		int i = 0;
		double ans = 0;
		while(i < n && w > 0){
			if(mPair[i].weight <= w){
				w -= mPair[i].weight;
				ans += (double)mPair[i].value;
			}else{
				ans += (double)(w * mPair[i].ratio);
				w = 0;
			}
			i++;
		}

		return ans;
    }
}