class Solution {
    
//     public void dfs(int initialSrc, int src, ArrayList<Integer>[] graph, int[] depth){
        
//         for(int child : graph[src]){
//             dfs(initialSrc, child, graph, depth);
//             depth[initialSrc] = Math.max(depth[initialSrc] , depth[initialSrc] + 1);
//         }
        
//     }
    
//     public int longestIncreasingPath(int[][] matrix) {
        
//         int r = matrix.length;
//         int c = matrix[0].length;
        
//         int n = matrix.length * matrix[0].length;
//         ArrayList<Integer>[] adj = new ArrayList[n];
        
//         for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
//         for(int i = 0; i < r; i++){
//             for(int j = 0; j < r; j++){
//                 if(i != 0 && matrix[i][j] < matrix[i-1][j]){
//                     int ourCellNo = (i * c) + j;
//                     int hisCellNo = ourCellNo - c;
                    
//                     adj[ourCellNo].add(hisCellNo);
//                 }
//                 if(i != r-1 && matrix[i][j] < matrix[i+1][j]){
//                     int ourCellNo = (i * c) + j;
//                     int hisCellNo = ourCellNo + c;
                    
//                     adj[ourCellNo].add(hisCellNo);
//                 }
//                 if(j != 0 && matrix[i][j] < matrix[i][j-1]){
//                     int ourCellNo = (i * c) + j;
//                     int hisCellNo = ourCellNo - 1;
                    
//                     adj[ourCellNo].add(hisCellNo);
//                 }
//                 if(j != c-1 && matrix[i][j] < matrix[i][j+1]){
//                     int ourCellNo = (i * c) + j;
//                     int hisCellNo = ourCellNo + 1;
                    
//                     adj[ourCellNo].add(hisCellNo);
//                 }
//             }
//         }
        
        
//         int[] depth = new int[n];
//         // Arrays.fill(depth, -1);
        
//         for(int i = 0; i < n; ++i){
//             dfs(i, i, adj, depth);
//         }
        
//         int ans = -1;
//         for(int i = 0; i < n; ++i) ans = Math.max(ans, depth[i]);
//         return ans;
        public int longestIncreasingPath(int[][] matrix) {
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int[] d : dp) Arrays.fill(d, -1);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                max = Math.max(max,dfs(matrix, i, j, dir, dp));
            }
        }
        return max;
    }
    
    public int dfs(int[][] arr, int sr, int sc, int[][] dir, int[][] dp){
        if(dp[sr][sc] != -1) return dp[sr][sc];
        int count = 0;
        for(int d = 0 ; d < dir.length ; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r < arr.length && c < arr[0].length && r >= 0 && c >= 0 && arr[r][c] > arr[sr][sc]){
                count = Math.max(count,dfs(arr, r, c, dir, dp));
            }
        }
        return dp[sr][sc] = count + 1;
    }
}