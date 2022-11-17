//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        
        int res = 0;
        
        HashMap<Integer, Integer> xMap = new HashMap<>();
        for(int i = 0; i < N; ++i){
            int x = X[i];
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
        }
        
        int xRes = 0;
        for(int key : xMap.keySet()){
            int freq = xMap.get(key);
            xRes += (freq * (freq - 1)) / 2;
        }
        
        HashMap<Integer, Integer> yMap = new HashMap<>();
        for(int i = 0; i < N; ++i){
            int y = Y[i];
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }
        
        int yRes = 0;
        for(int key : yMap.keySet()){
            int freq = yMap.get(key);
            yRes += (freq * (freq - 1)) / 2;
        }
        
        HashMap<String, Integer> xyMap = new HashMap<>();
        for(int i = 0; i < N; ++i){
            int x = X[i];
            int y = Y[i];
            
            String key = x + "#" + y;
            xyMap.put(key, xyMap.getOrDefault(key, 0) + 1);
        }
        
        int xyRes = 0;
        for(String key : xyMap.keySet()){
            int freq = xyMap.get(key);
            xyRes += (freq * (freq - 1)) / 2;
        }
        
        res = xRes + yRes - (2 * xyRes);
        
        return res;
        
    }
};