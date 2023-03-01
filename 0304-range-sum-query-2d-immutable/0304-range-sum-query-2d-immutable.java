class NumMatrix {
    int[][] preMat;
    public NumMatrix(int[][] matrix) {
        preMat = new int[matrix.length + 1]
                        [matrix[0].length + 1];
        
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                preMat[i+1][j+1] = preMat[i+1][j] +
                                   preMat[i][j+1] - 
                                   preMat[i][j] +
                                   matrix[i][j];
            }
        }   
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preMat[row2+1][col2+1] -
               preMat[row2+1][col1] - 
               preMat[row1][col2+1] +
               preMat[row1][col1]; 
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */