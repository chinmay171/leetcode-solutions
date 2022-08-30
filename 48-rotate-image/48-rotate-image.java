class Solution {
    public static void reverse(int[][] arr, int row)
  {
      int left = 0, right = arr[row].length - 1;
      while(left < right)
      {
          int temp = arr[row][left];
          arr[row][left] = arr[row][right];
          arr[row][right] = temp;
          
          left++; right--;
      }
  }
    public void rotate(int[][] arr) {
        int n = arr.length;
        for(int rows = 0; rows < n; rows++){
            for(int cols = rows + 1; cols < n; cols++){
                int temp = arr[rows][cols];
                arr[rows][cols] = arr[cols][rows];
                arr[cols][rows] = temp;
            }
        }
        for(int rows = 0; rows < n; rows++) 
            reverse(arr, rows);
    }
}