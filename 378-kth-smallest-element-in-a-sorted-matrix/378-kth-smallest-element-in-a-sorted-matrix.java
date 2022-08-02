class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        int size = r*c;
        int[] arr = new int[size];
        int count = 0;
        for(int i = 0; i<matrix.length; ++i){
            for(int j = 0; j<matrix[0].length; ++j){
                arr[count] = matrix[i][j];
                count++;
            }
        }
        // System.out.print(arr);
        Arrays.sort(arr);
        return arr[k-1];
    }
}