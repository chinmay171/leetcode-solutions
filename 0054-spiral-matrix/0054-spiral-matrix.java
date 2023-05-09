class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0;
        int y = 0;
        
        int i = 0;
        int j = 0;
        
        int dir = 1;
        // 1 -> RH
        // 2 -> DV
        // 3 -> LH
        // 4 -> UV
        List<Integer> ans = new ArrayList<>();
        while(i < n && j < m && j >= y && i >= x){
            if(dir == 1){
                while(j < m){
                    ans.add(matrix[i][j]);
                    j++;
                }
                x++;
                j--;
                i++;
                dir = 2;
            }else if(dir == 2){
                while(i < n){
                    ans.add(matrix[i][j]);
                    i++;
                }
                m--;
                i--;
                j--;
                dir = 3;
            }else if(dir == 3){
                while(j >= y){
                    ans.add(matrix[i][j]);
                    j--;
                }
                n--;
                j++;
                i--;
                dir = 4;
            }else{
                while(i >= x){
                    ans.add(matrix[i][j]);
                    i--;
                }
                y++;
                i++;
                j++;
                dir = 1;
            }
        }
        
        return ans;
    }
}