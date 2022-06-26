class Solution {
    public boolean searchMatrix1(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n*m-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            
            int rowId = mid/m;
            int colId = mid%m;
            
            if(matrix[rowId][colId] == target){
                return true;
            }else if(matrix[rowId][colId] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix1(matrix, target);
    }
}