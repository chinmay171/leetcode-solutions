class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int up = 0, down = n, left = 0, right = n;
        int i = 0, j = 0;
        int cellValue = 1;
        
        while(cellValue <= n*n){
            while(j < right) ans[i][j++] = cellValue++;
            i++;
            j--;
            up++;
            while(i < down) ans[i++][j] = cellValue++;
            i--;
            j--;
            right--;
            while(j >= left) ans[i][j--] = cellValue++;
            i--;
            j++;
            down--;
            while(i >= up) ans[i--][j] = cellValue++;
            i++;
            j++;
            left++;
        }
        
        return ans;
    }
}