class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        
        int i = 0, j = 0;
        while(i < n && j < n) sum += mat[i++][j++];
        i = n-1; j = 0; 
        while(i >= 0 && j < n) sum += mat[i--][j++];
        
        return (n % 2 == 1) ? sum -= mat[n/2][n/2] : sum;
    }
}