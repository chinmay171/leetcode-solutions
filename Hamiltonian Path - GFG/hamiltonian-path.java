//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ // 1 -> 2 -> 3 -> 4
//        -> 4
    static boolean dfs(int src, ArrayList<Integer>[] adj, boolean[] vis, int currVis){
        if(vis[src] == true){
            if(currVis == adj.length) return true;
            else return false;
        }
        
        vis[src] = true;
        currVis += 1;
        for(Integer nbr : adj[src])
            if(dfs(nbr, adj, vis, currVis) == true) return true;
        vis[src] = false;
        currVis -= 1;
        return false;
    }
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<Integer>[] adj = new ArrayList[N];
        for(int i = 0; i < N; ++i) adj[i] = new ArrayList<>();

        // System.out.println(adj.length);
        for(int i = 0; i < Edges.size(); ++i){
            ArrayList<Integer> edge = Edges.get(i);
            // System.out.println(edge.get(0) + " " + edge.get(1));
            adj[edge.get(0)-1].add(edge.get(1)-1);
            adj[edge.get(1)-1].add(edge.get(0)-1);
        }
        
        boolean[] vis = new boolean[N];
        for(int i = 0; i < adj.length; ++i){
            if(dfs(i, adj, vis, 0) == true) return true;
        }
        return false;
    }
} 