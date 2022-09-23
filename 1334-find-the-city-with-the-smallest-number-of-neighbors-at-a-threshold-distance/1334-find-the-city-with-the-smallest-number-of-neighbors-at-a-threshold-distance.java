class Solution {
    public int findTheCity(int n, int[][] edges, int distThresh) {
        
        int[][] matrix = new int[n][n];
        
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                matrix[i][j] = -1;
        
        for(int[] edge : edges){
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }
            
        for(int inter = 0; inter < n; inter++){
            for(int src = 0; src < n; src++){
                for(int dest = 0; dest < n; dest++){
                    int oldDist = (matrix[src][dest] != -1)
                                 ? matrix[src][dest]
                                 : Integer.MAX_VALUE;
                    if(matrix[src][inter] != -1 && matrix[inter][dest] != -1){
                        matrix[src][dest] = Math.min(matrix[src][inter] + matrix[inter][dest], oldDist);
                    }
                }
            }
        }
        
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                if(i == j)
                    matrix[i][j] = Integer.MAX_VALUE;
        
        int[] ansArr = new int[n];
        int ansVal = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] <= distThresh){
                    ansArr[i]++;
                }
            }
            if(ansVal >= ansArr[i]){
                ansVal = ansArr[i];
                ans = i;
            }
        }
        
        return ans;
    }
}